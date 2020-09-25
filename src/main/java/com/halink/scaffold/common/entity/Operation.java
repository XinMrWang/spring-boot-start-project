package com.halink.scaffold.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限资源
 *
 * @author halink
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private Integer operationId;

    /**
     * 操作名称
     */
    private String operationName;

    private String operationDesc;

    /**
     * 请求路径
     */
    private String requestUrl;

    private Integer permissionId;

    /**
     * 接口注解
     */
    private String perm;

    private String route;

    /**
     * 0路由,1按钮
     */
    private Byte type;

    private Integer operationCode;
}