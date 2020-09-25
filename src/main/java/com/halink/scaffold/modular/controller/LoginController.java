package com.halink.scaffold.modular.controller;

import com.halink.scaffold.common.params.TestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author halink
 * @date 2019/11/26 5:04 下午
 */
@Api(tags = "测试")
@RestController
public class LoginController {

    @GetMapping("/login")
    @ApiOperation("测试接口")
    public String login(TestParam testParam) {
        return "中文乱码";
    }
}
