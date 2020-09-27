package com.halink.scaffold.config.globalexception;

import com.halink.scaffold.common.constant.ExceptionCodeConstants;
import com.halink.scaffold.common.constant.ExceptionMessageConstants;
import com.halink.scaffold.common.exception.BaseException;
import com.halink.scaffold.common.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author halink
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult dealException(HttpServletRequest req, Throwable e) {
        log.error("system error - ", e);
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
