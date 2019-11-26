package com.lsc.startproject.common.entity;

import java.util.Date;
import lombok.Data;

@Data
public class RolePermissionRelation {
    private String roleId;

    /**
    * 权限id
    */
    private String permissionId;

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
}