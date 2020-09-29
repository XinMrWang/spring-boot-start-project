package com.halink.scaffold.common.constant;

/**
 * 异常code
 *
 * @author halink
 */
public class ExceptionCodeConstants {
    public static final Integer SYSTEM_ERROR = 999;
    // 转换异常 10000
    /**
     * 接收枚举数据异常
     */
    public static final Integer ACCEPT_ENUM_FORMAT_EXCEPTION = 10001;

    /**
     * 请求异常
     */
    //请求体异常
    public static final Integer REQUEST_BODY_EXCEPTION = 20001;
    //请求方法不对
    public static final Integer REQUEST_METHOD_EXCEPTION = 20002;

    /**
     * 参数异常
     */
    public static final Integer PARAMETER_EXCEPTION = 30001;

    /**
     * 登录 & 验证码
     */
    public static final Integer VERIFICATION_CODE_GENERATE_EXCEPTION = 40007;
    public static final Integer IMAGE_VERIFICATION_CODE_IS_NULL_EXCEPTION = 40001;
    public static final Integer IMAGE_VERIFICATION_CODE_EXPIRED_EXCEPTION = 40002;
    public static final Integer IMAGE_VERIFICATION_CODE_FAULT_EXCEPTION = 40003;
    public static final Integer PHONE_VERIFICATION_CODE_IS_NULL_EXCEPTION = 40004;
    public static final Integer PHONE_VERIFICATION_CODE_EXPIRED_EXCEPTION = 40005;
    public static final Integer PHONE_VERIFICATION_CODE_FAULT_EXCEPTION = 40006;
}
