package com.lsc.startproject.config;


import com.lsc.startproject.common.vo.ResponseResult;
import com.lsc.startproject.core.util.ResultUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对返回数据进行分装
 * @author halink
 */
@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice {

    /**
     * 用于可以根据方法类型和Controller名，确定进行返回数据包装的scope。
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * 包装返回数据
     */
    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequet,
                                  ServerHttpResponse serverHttpResponse) {
        if (data instanceof String) {
            serverHttpResponse.getHeaders().add("Content-Type",
                    "application/json");
        }
        if (data instanceof ResponseResult) {
            return data;
        } else {
            return ResultUtil.success(data);
        }
    }
}
