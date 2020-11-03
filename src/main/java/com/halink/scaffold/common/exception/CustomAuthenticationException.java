package com.halink.scaffold.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义AuthenticationException
 * spring security的filter抛出的异常全局异常拦截不到
 *
 * @author halink
 * @date 2020/9/29 4:35 下午
 */
public class CustomAuthenticationException extends AuthenticationException {
    public CustomAuthenticationException(String msg) {
        super(msg);
    }

    public static CustomAuthenticationException getInstance(String msg) {
        return new CustomAuthenticationException(msg);
    }
}
