package com.lsc.startproject.config.springsecurity;

import com.alibaba.fastjson.JSON;
import com.lsc.startproject.common.constant.ResponseCodeConstants;
import com.lsc.startproject.common.constant.ResponseMessageConstants;
import com.lsc.startproject.common.dto.UserDto;
import com.lsc.startproject.core.util.JwtTokenUtil;
import com.lsc.startproject.core.util.RedisUtil;
import com.lsc.startproject.core.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author halink
 * @date 2019/11/27 3:32 下午
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${token.expirationMilliSeconds}")
    private long expirationMilliSeconds;

    @Autowired
    RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取header中的token信息
        String authHeader = request.getHeader("Authorization");
        response.setCharacterEncoding("utf-8");
        if (null == authHeader || !authHeader.startsWith("Bearer ")) {
            //token格式不正确
            filterChain.doFilter(request, response);
            return;
        }
        String authToken = authHeader.substring("Bearer ".length());

        //获取在token中自定义的subject，用作用户标识，用来获取用户权限
        String subject = JwtTokenUtil.parseToken(authToken);

        //获取redis中的token信息

        if (!redisUtil.hasKey(authToken)) {
            //token 不存在 返回错误信息
            response.getWriter().write(
                    JSON.toJSONString(
                            ResultUtil.response(
                                    ResponseCodeConstants.NO_LOGIN_IN,
                                    ResponseMessageConstants.NO_LOGIN_IN
                            )
                    )
            );
            return;
        }
        //获取缓存中的信息(根据自己的业务进行拓展)
        Map<Object, Object> hashMap = redisUtil.hmget(authToken);
        //从tokenInfo中取出用户信息
        UserDto user = UserDto.builder().id(Long.parseLong(hashMap.get("id").toString()))
                .authorities((Set<? extends GrantedAuthority>) hashMap.get("authorities")).build();
        if (MapUtils.isEmpty(hashMap)) {
            //用户信息不存在或转换错误，返回错误信息
            response.getWriter().write(
                    JSON.toJSONString(
                            ResultUtil.response(
                                    ResponseCodeConstants.NO_LOGIN_IN,
                                    ResponseMessageConstants.NO_LOGIN_IN
                            )
                    )
            );
            return;
        }
        //更新token过期时间
        redisUtil.expire(authToken, expirationMilliSeconds);
        //将信息交给security
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
