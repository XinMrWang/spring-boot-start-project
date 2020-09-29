package com.halink.scaffold.config.springsecurity.service;

import com.google.common.collect.Sets;
import com.halink.scaffold.common.dto.UserDto;
import com.halink.scaffold.common.entity.User;
import com.halink.scaffold.modular.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 登录验证
 *
 * @author halink
 * @date 2019/11/27 11:41 上午
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    /**
     * 若使用security表单鉴权则需实现该方法，通过username获取用户信息（密码、权限等等）
     *
     * @param username username
     * @return userDetails
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.selectByPrimaryKey(0L);
        if (user == null) {
            log.error("username not found! username:{}", username);
            throw new UsernameNotFoundException("用户不存在");
        }
        Set<SimpleGrantedAuthority> authoritiesSet = Sets.newHashSet();
        // 模拟从数据库中获取用户权限
        authoritiesSet.add(new SimpleGrantedAuthority("test:list"));
        authoritiesSet.add(new SimpleGrantedAuthority("test:add"));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setAuthorities(authoritiesSet);
        return userDto;
    }
}
