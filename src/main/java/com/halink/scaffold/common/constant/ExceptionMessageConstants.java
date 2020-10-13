package com.halink.scaffold.common.constant;

/**
 * 异常消息
 *
 * @author halink
 */
public class ExceptionMessageConstants {

    public static final String ACCEPT_ENUM_FORMAT_EXCEPTION = "接收的枚举数据信息异常";
    public static final String SYSTEM_EXCEPTION = "系统开小差了，请稍后再试";
    public static final String REQUEST_BODY_EXCEPTION = "请求体反序列化异常";
    public static final String PARAMETER_EXCEPTION = "参数异常";
    public static final String REQUEST_METHOD_EXCEPTION = "请求方法异常,%s";

    /**
     * 登录 & 验证码
     */
    public static final String VERIFICATION_CODE_GENERATE_EXCEPTION = "验证码生成异常";
    public static final String IMAGE_VERIFICATION_CODE_IS_NULL_EXCEPTION = "图片验证码为空";
    public static final String IMAGE_VERIFICATION_CODE_EXPIRED_EXCEPTION = "图片验证码已超时";
    public static final String IMAGE_VERIFICATION_CODE_FAULT_EXCEPTION = "图片验证码错误";
    public static final String PHONE_VERIFICATION_CODE_IS_NULL_EXCEPTION = "短信验证码为空";
    public static final String PHONE_VERIFICATION_CODE_EXPIRED_EXCEPTION = "短信验证码已超时";
    public static final String PHONE_VERIFICATION_CODE_FAULT_EXCEPTION = "短信验证码错误";
}
