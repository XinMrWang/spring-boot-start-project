package com.lsc.startproject.common.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Role {
    /**
    * 角色id

超级管理员
owner

    */
    private String roleId;

    /**
    * 角色名称
    */
    private String roleName;

    private String roleDesc;

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
    * 权限2进制和
    */
    private String permissionCodeSet;

    /**
    * 是否共有
    */
    private Byte isPublic;
}