package com.halink.scaffold.config.springsecurity.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.halink.scaffold.common.constant.ResponseCodeConstants;
import com.halink.scaffold.common.constant.ResponseMessageConstants;
import com.halink.scaffold.core.util.ResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 没有登录
 *
 * @author halink
 * @date 2019/11/27 11:17 上午
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        ResultUtil.response(
                                ResponseCodeConstants.NO_LOGIN_IN,
                                ResponseMessageConstants.NO_LOGIN_IN
                        )
                )
        );
    }
}

