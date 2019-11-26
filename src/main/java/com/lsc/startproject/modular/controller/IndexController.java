package com.lsc.startproject.modular.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author likeshuang
 * @date 2019/11/26 5:04 下午
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/s")
    public String test() {
        return "中文乱码";
    }
}
