package com.halink.scaffold.modular.controller;

import com.google.common.collect.Lists;
import com.halink.scaffold.common.enumerate.UserStatuesEnum;
import com.halink.scaffold.common.vo.user.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author halink
 * @date 2019/11/26 5:04 下午
 */
@Api(tags = "测试")
@RestController
public class LoginController {

    @PostMapping("/login")
    @ApiOperation("测试接口")
    public UserVo login(@RequestBody UserVo userVos) {
        return UserVo.builder()
                .areaCode("861")
                .email("email")
                .headPic("headPic")
                .lastLoginTime(new Date())
                .status(Lists.newArrayList(UserStatuesEnum.NORMAL))
                .phone("12345678912")
                .username("username")
                .build();
    }
}
