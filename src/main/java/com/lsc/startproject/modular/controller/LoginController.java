package com.lsc.startproject.modular.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author halink
 * @date 2019/11/26 5:04 下午
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "中文乱码";
    }
}
