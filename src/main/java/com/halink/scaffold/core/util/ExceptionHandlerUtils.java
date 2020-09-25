package com.halink.scaffold.core.util;

import com.halink.scaffold.common.constant.ExceptionCodeConstants;
import com.halink.scaffold.common.constant.ExceptionMessageConstants;
import com.halink.scaffold.common.exception.BaseException;
import com.halink.scaffold.common.vo.ResponseResult;

/**
 * 异常返回数据封装
 */
public class ExceptionHandlerUtils {

    public static ResponseResult restApiExceptionHandler(Throwable e) {
        ResponseResult restResponse = new ResponseResult();
        if (e instanceof BaseException) {
            BaseException se = (BaseException) e;
            restResponse.setCode(se.getErrorCode());
            restResponse.setMessage(se.getErrorMsg());
        } else {
            restResponse.setCode(ExceptionCodeConstants.SYSTEM_ERROR);
            restResponse.setMessage(ExceptionMessageConstants.SYSTEM_EXCEPTION);
        }
        return restResponse;
    }
}
