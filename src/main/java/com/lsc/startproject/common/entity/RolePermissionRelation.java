package com.lsc.startproject.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色权限关系
 *
 * @author halink
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionRelation {
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;

    /**
     * 创建用户
     */
    private Long userCreate;

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
}