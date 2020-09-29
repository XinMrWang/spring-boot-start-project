package com.halink.scaffold.modular.controller;

import com.halink.scaffold.modular.service.VerificationCodeService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码
 *
 * @author halink
 * @date 2020/9/29 3:48 下午
 */
@Api(tags = "验证码")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/verification-code")
public class VerificationCodeController {

    private final VerificationCodeService verificationCodeService;

    @GetMapping("/image")
    public void image(HttpServletRequest request, HttpServletResponse response) {
        verificationCodeService.image(request, response);
    }

}
