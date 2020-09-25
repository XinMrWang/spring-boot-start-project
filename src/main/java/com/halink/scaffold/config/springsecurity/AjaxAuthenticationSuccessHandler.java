package com.halink.scaffold.config.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halink.scaffold.common.constant.ResponseCodeConstants;
import com.halink.scaffold.common.constant.ResponseMessageConstants;
import com.halink.scaffold.core.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

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
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        //自定义login，不走这里、若使用security的formLogin则自己添加业务实现(生成token、存储token等等)
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        ResultUtil.response(
                                ResponseCodeConstants.LOGIN_SUCCESS,
                                ResponseMessageConstants.LOGIN_SUCCESS
                        )
                )
        );
    }
}
