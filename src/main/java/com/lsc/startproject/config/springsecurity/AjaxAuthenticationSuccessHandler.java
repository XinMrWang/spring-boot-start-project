package com.lsc.startproject.config.springsecurity;

import com.alibaba.fastjson.JSON;
import com.lsc.startproject.common.constant.ResponseCodeConstants;
import com.lsc.startproject.common.constant.ResponseMessageConstants;
import com.lsc.startproject.core.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功
 *
 * @author likeshuang
 * @date 2019/11/27 11:18 上午
 */
@Component
@Slf4j
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    //@Autowired
    //private RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //自定义login，不走这里、若使用security的formLogin则自己添加业务实现(生成token、存储token等等)
        response.getWriter().write(
                JSON.toJSONString(
                        ResultUtil.response(
                                ResponseCodeConstants.LOGIN_SUCCESS,
                                ResponseMessageConstants.LOGIN_SUCCESS
                        )
                )
        );
    }
}
