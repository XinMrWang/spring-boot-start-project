package com.lsc.startproject.core.util;

import com.alibaba.druid.util.HttpClientUtils;
import com.lsc.startproject.common.constant.ResponseCodeConstants;
import com.lsc.startproject.common.constant.ResponseMessageConstants;
import com.lsc.startproject.common.vo.ResponseResult;

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
}
