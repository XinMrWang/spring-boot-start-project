package com.halink.scaffold.modular.controller;

import com.google.common.collect.Lists;
import com.halink.scaffold.common.enumerate.UserStatuesEnum;
import com.halink.scaffold.common.vo.user.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author halink
 * @date 2019/11/26 5:04 下午
 */
@Api(tags = "测试")
@Validated
@RestController
public class LoginController {

    @RequestMapping("/login")
    @ApiOperation("测试接口")
    public UserVo login(@NotEmpty(message = "这玩意儿不能为空") String a) {
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
