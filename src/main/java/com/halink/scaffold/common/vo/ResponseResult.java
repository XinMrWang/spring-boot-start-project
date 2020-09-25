package com.halink.scaffold.common.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author halink
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private Object data;
    private String message;
    private Integer code;
}
