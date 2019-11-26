package com.lsc.startproject.common.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Permission {
    /**
    * 权限id
    */
    private String permissionId;

    /**
    * 权限名称
    */
    private String permissionName;

    /**
    * 创建用户
    */
    private String userCreate;

    /**
    * 修改用户
    */
    private String userModified;

    /**
    * 创建时间
    */
    private Date gmtCreate;

    /**
    * 修改时间
    */
    private Date gmtModified;

    /**
    * 权限id
    */
    private Integer permissionCode;

    /**
    * 路由id
    */
    private String dependencyId;

    private String pid;
}