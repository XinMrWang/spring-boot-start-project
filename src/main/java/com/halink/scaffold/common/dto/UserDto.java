package com.halink.scaffold.common.dto;

import com.halink.scaffold.common.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDto extends User implements UserDetails, Serializable {

    /**
     * 权限列表
     */
    private Set<? extends GrantedAuthority> authorities;

//    @Builder
//    public UserDto(Set<? extends GrantedAuthority> authorities, Long userId, String username, String password, String email, String areaCode, String phone, Date registTime, Byte status, Boolean markDeleted, Date gmtModified, Date lastLoginTime, String headPic) {
//        super(userId, username, password, email, areaCode, phone, registTime, status, markDeleted, gmtModified, lastLoginTime, headPic);
//        this.authorities = authorities;
//    }

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
