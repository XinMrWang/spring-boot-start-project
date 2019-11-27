package com.lsc.startproject.config.globalexception;

import com.lsc.startproject.common.vo.ResponseResult;
import com.lsc.startproject.core.util.ExceptionHandlerUtils;
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
        return ExceptionHandlerUtils.restApiExceptionHandler(e);
    }

}
