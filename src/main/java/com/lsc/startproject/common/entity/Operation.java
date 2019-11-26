package com.lsc.startproject.common.entity;

import lombok.Data;

@Data
public class Operation {
    private String operationId;

    /**
    * 操作名称
    */
    private String operationName;

    private Integer operationCode;

    private String operationDesc;

    /**
    * 请求路径
    */
    private String requestUrl;

    private String permissionId;

    /**
    * shiro对应的接口注解
    */
    private String perm;

    private String route;

    /**
    * 0 路由\\n1 按钮
    */
    private Byte type;
}