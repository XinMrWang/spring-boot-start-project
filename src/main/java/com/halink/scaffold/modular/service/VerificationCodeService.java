package com.halink.scaffold.modular.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码服务
 *
 * @author halink
 * @date 2020/9/29 4:00 下午
 */
public interface VerificationCodeService {
    /**
     * 生成图片验证码
     *
     * @param request  request
     * @param response response
     */
    void image(HttpServletRequest request, HttpServletResponse response);

}
