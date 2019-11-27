package com.lsc.startproject.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户用于整合spring,security
 *
 * @author halink
 * @date 2019/11/27 3:10 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserDetails, Serializable {
    private Long id;
    private String username;
    private String password;
    /**
     * 权限列表
     */
    private Set<? extends GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
