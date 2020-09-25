package com.halink.scaffold.modular.service.impl;

import com.halink.scaffold.common.dto.UserDto;
import com.halink.scaffold.common.entity.User;
import com.halink.scaffold.modular.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 登录验证
 *
 * @author likeshuang
 * @date 2019/11/27 11:41 上午
 */
@Component
@Slf4j
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 若使用security表单鉴权则需实现该方法，通过username获取用户信息（密码、权限等等）
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过username查询用户
        User user = userMapper.selectByPrimaryKey(1L);
        if (user == null) {
            //仍需要细化处理
            throw new UsernameNotFoundException("该用户不存在");
        }
        Set<SimpleGrantedAuthority> authoritiesSet = new HashSet<>();
        // 模拟从数据库中获取用户权限
        authoritiesSet.add(new SimpleGrantedAuthority("test:list"));
        authoritiesSet.add(new SimpleGrantedAuthority("test:add"));
        log.info("用户{}验证通过", username);
        return UserDto.builder().id(user.getUserId())
                .password(user.getPassword())
                .username(user.getUsername())
                .authorities(authoritiesSet).build();
    }

}
