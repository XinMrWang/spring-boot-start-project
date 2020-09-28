package com.halink.scaffold.modular.controller;

import com.google.common.collect.Lists;
import com.halink.scaffold.common.entity.User;
import com.halink.scaffold.common.enumerate.UserStatuesEnum;
import com.halink.scaffold.common.vo.user.UserVo;
import com.halink.scaffold.config.globalresponse.SuccessResponse;
import com.halink.scaffold.modular.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * @author halink
 * @date 2019/11/26 5:04 下午
 */
@Api(tags = "测试")
@Validated
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserMapper userMapper;

    @SuccessResponse
    @RequestMapping("/login")
    @ApiOperation("测试接口")
    public UserVo login(@NotEmpty(message = "这玩意儿不能为空") String a) {
        User user = User.builder().status(UserStatuesEnum.NORMAL).password("$2a$10$5Am5J8RDnBslVJje.C89S.jAPC2k98Zc4sRO2E2epQxuCtb5mZ9Xe").build();
        userMapper.insertSelective(user);
        userMapper.selectByPrimaryKey(user.getUserId());
        return UserVo.builder().status(Lists.newArrayList(UserStatuesEnum.NORMAL, UserStatuesEnum.NORMAL)).build();
    }
}
