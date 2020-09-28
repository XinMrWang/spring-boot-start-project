package com.halink.scaffold.common.exception;

import lombok.Getter;


/**
 * @author halink
 */
@Getter
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 424646336423235612L;

    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 错误信息
     */
    private final String errorMsg;

    public BaseException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BaseException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorMsg = errorMsg;
    }
}
