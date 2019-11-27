package com.lsc.startproject.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色
 *
 * @author halink
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /**
     * 角色id
     * <p>
     * 超级管理员
     * owner
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    private String roleDesc;

    /**
     * 创建用户
     */
    private Integer userCreate;

    /**
     * 修改用户
     */
    private Long userModified;

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
    private Integer permissionCodeSet;
}