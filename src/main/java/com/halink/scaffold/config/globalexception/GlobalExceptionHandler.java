package com.halink.scaffold.config.globalexception;

import com.halink.scaffold.common.constant.ExceptionCodeConstants;
import com.halink.scaffold.common.constant.ExceptionMessageConstants;
import com.halink.scaffold.common.exception.BaseException;
import com.halink.scaffold.common.vo.ResponseResult;
import com.halink.scaffold.core.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;

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


    /**
     * 添加参数校验的Exception处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult dealMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Param Error -> ", e);
        StringBuilder errorString = new StringBuilder();
        StringBuilder errorMsg = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorString.append(fieldName).append(":").append(errorMessage).append("! ");
            errorMsg.append(errorMessage).append("! ");
        });
        log.error("Param Error -> {}", errorString);
        return ResultUtil.response(ExceptionCodeConstants.PARAMETER_EXCEPTION, errorMsg.toString());
    }

    /**
     * 添加参数校验的BindException处理
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseResult dealBindException(BindException e) {
        log.error("Param Error -> ", e);
        StringBuilder errorString = new StringBuilder();
        StringBuilder errorMsg = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorString.append(fieldName).append(":").append(errorMessage).append("! ");
            errorMsg.append(errorMessage).append("! ");
        });
        log.error("Param Error -> {}", errorString);
        return ResultUtil.response(ExceptionCodeConstants.PARAMETER_EXCEPTION, errorMsg.toString());
    }

    /**
     * 添加参数校验的ConstraintViolationException处理
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseResult dealConstraintViolationException(ConstraintViolationException e) {
        log.error("Param Error -> ", e);
        StringBuilder errorMsg = new StringBuilder();
        String[] msgs = e.getMessage().split(", ");
        for (String msg : msgs) {
            String[] fieldAndMsg = msg.split(": ");
            String message = fieldAndMsg[1];
            errorMsg.append(message).append("! ");
        }
        return ResultUtil.response(ExceptionCodeConstants.PARAMETER_EXCEPTION, errorMsg.toString());
    }


    /**
     * 请求体丢失异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseResult dealHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("请求体异常 Error -> ", e);
        return ResultUtil.response(ExceptionCodeConstants.REQUEST_BODY_EXCEPTION, ExceptionMessageConstants.REQUEST_BODY_EXCEPTION);
    }

    /**
     * 请求METHOD异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseResult dealHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("请求体异常 Error -> ", e);
        String[] supportedMethods = e.getSupportedMethods();
        String errorMessage;
        if (null == supportedMethods || supportedMethods.length == 0) {
            errorMessage = "请求方法未知,请联系管理员";
        } else {
            errorMessage = "请使用" + Arrays.toString(supportedMethods) + "方法";
        }
        return ResultUtil.response(ExceptionCodeConstants.REQUEST_METHOD_EXCEPTION, String.format(ExceptionMessageConstants.REQUEST_METHOD_EXCEPTION, errorMessage));
    }

}
