package com.lsc.startproject.config.springsecurity;


import com.alibaba.fastjson.JSON;
import com.lsc.startproject.common.constant.ResponseCodeConstants;
import com.lsc.startproject.common.constant.ResponseMessageConstants;
import com.lsc.startproject.core.util.ResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 没有登录
 *
 * @author likeshuang
 * @date 2019/11/27 11:17 上午
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.getWriter().write(
                JSON.toJSONString(
                        ResultUtil.response(
                                ResponseCodeConstants.NO_LOGIN_IN,
                                ResponseMessageConstants.NO_LOGIN_IN
                        )
                )
        );
    }
}

