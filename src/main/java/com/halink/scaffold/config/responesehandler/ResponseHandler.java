package com.halink.scaffold.config.responesehandler;


import com.halink.scaffold.common.vo.ResponseResult;
import com.halink.scaffold.core.util.ResultUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对返回数据进行分装
 *
 * @author halink
 */
@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    /**
     * 用于可以根据方法类型和Controller名，确定进行返回数据包装的scope。
     */
    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            response.getHeaders().add("Content-Type",
                    "application/json");
        }
        if (body instanceof ResponseResult) {
            return body;
        } else {
            return ResultUtil.success(body);
        }
    }
}
