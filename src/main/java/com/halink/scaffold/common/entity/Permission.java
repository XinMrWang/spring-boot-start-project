package com.halink.scaffold.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 权限
 *
 * @author halink
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

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

    /**
     * 依赖id
     */
    private Long dependencyId;

    /**
     * 父id
     */
    private Long pid;

    private Integer permissionCode;
}