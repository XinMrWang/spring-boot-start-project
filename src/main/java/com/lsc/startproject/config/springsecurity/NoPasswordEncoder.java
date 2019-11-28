package com.lsc.startproject.config.springsecurity;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author halink
 * @date 2019/11/27 3:33 下午
 */
public class NoPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return "";
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return true;
    }
}