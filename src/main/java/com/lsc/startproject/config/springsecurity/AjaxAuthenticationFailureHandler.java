package com.lsc.startproject.config.springsecurity;

import com.alibaba.fastjson.JSON;
import com.lsc.startproject.common.constant.ResponseCodeConstants;
import com.lsc.startproject.common.constant.ResponseMessageConstants;
import com.lsc.startproject.core.util.ResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败
 *
 * @author likeshuang
 * @date 2019/11/27 11:18 上午
 */
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(
                JSON.toJSONString(
                        ResultUtil.response(
                                ResponseCodeConstants.LOGIN_FAILURE,
                                ResponseMessageConstants.LOGIN_FAILURE
                        )
                )
        );
    }
}
