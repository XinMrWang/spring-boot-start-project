package com.halink.scaffold.common.exception;

import com.halink.scaffold.common.constant.ExceptionCodeConstants;
import com.halink.scaffold.common.constant.ExceptionMessageConstants;

/**
 * 接收枚举数据异常
 *
 * @author halink
 * @date 2020/9/27 6:49 下午
 */
public class AcceptEnumFormatException extends BaseException {
    public AcceptEnumFormatException() {
        super(ExceptionCodeConstants.ACCEPT_ENUM_FORMAT_EXCEPTION, ExceptionMessageConstants.ACCEPT_ENUM_FORMAT_EXCEPTION);
    }
}
