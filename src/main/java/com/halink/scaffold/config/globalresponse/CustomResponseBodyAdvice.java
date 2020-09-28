package com.halink.scaffold.config.globalresponse;

import com.halink.scaffold.common.vo.ResponseResult;
import com.halink.scaffold.core.util.ResultUtil;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;

/**
 * 结合SuccessResponse结合对相应数据进行统一封装
 *
 * @author halink
 * @date 2020/9/28 10:23 上午
 */
@ControllerAdvice
public class CustomResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        AnnotatedElement annotatedElement = methodParameter.getAnnotatedElement();
        SuccessResponse focusController = AnnotationUtils.findAnnotation(annotatedElement, SuccessResponse.class);
        return focusController != null;
    }

    @Override
    public ResponseResult beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return ResultUtil.success(object);
    }
}
