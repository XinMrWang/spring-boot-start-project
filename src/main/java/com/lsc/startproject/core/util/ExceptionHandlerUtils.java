package com.lsc.startproject.core.util;

import com.lsc.startproject.common.constant.ExceptionCodeConstants;
import com.lsc.startproject.common.constant.ExceptionMessageConstants;
import com.lsc.startproject.common.exception.BaseException;
import com.lsc.startproject.common.vo.ResponseResult;

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
