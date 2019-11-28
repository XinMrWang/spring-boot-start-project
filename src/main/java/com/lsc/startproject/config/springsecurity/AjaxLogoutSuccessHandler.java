package com.lsc.startproject.config.springsecurity;

import com.alibaba.fastjson.JSON;
import com.lsc.startproject.common.constant.ResponseCodeConstants;
import com.lsc.startproject.common.constant.ResponseMessageConstants;
import com.lsc.startproject.core.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录成功
 *
 * @author halink
 * @date 2019/11/27 11:19 上午
 */
@Component
@Slf4j
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        //没有logout不走这里、若使用security的formLogin则自己添加业务实现（移除token等等）
        response.getWriter().write(
                JSON.toJSONString(
                        ResultUtil.response(
                                ResponseCodeConstants.LOGOUT_SUCCESS,
                                ResponseMessageConstants.LOGOUT_SUCCESS
                        )
                )
        );
    }

}
