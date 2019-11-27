package com.lsc.startproject.config.springsecurity;


import com.alibaba.fastjson.JSON;
import com.lsc.startproject.common.constant.ResponseCodeConstants;
import com.lsc.startproject.common.constant.ResponseMessageConstants;
import com.lsc.startproject.core.util.ResultUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 没有权限
 *
 * @author halink
 * @date 2019/11/27 11:16 上午
 */
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(
                JSON.toJSONString(
                        ResultUtil.response(
                                ResponseCodeConstants.NO_AUTHORITY,
                                ResponseMessageConstants.NO_AUTHORITY
                        )
                )
        );
    }
}

