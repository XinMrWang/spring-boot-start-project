package com.halink.scaffold.core.util;

import com.halink.scaffold.common.constant.ResponseCodeConstants;
import com.halink.scaffold.common.constant.ResponseMessageConstants;
import com.halink.scaffold.common.vo.ResponseResult;

/**
 * 预制几个返回数据
 *
 * @author halink
 * @date 2019/11/26 6:19 下午
 */
public class ResultUtil {

    public static ResponseResult success(Object data) {
        return ResponseResult.builder()
                .code(ResponseCodeConstants.SUCCESS)
                .data(data)
                .message(ResponseMessageConstants.SUCCESS).build();
    }

    public static ResponseResult failed(Object data) {
        return ResponseResult.builder()
                .code(ResponseCodeConstants.FAILED)
                .data(data)
                .message(ResponseMessageConstants.FAILED).build();
    }

    public static ResponseResult response(Integer code, String message) {
        return ResponseResult.builder()
                .code(code)
                .message(message).build();
    }

    public static ResponseResult response(Integer code, Object data, String message) {
        return ResponseResult.builder()
                .data(data)
                .code(code)
                .message(message).build();
    }
}
