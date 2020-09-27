package com.halink.scaffold.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-halink-scaffold-common-entity-Permission")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {
    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private Long permissionId;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String permissionName;

    /**
     * 创建用户
     */
    @ApiModelProperty(value = "创建用户")
    private Long userCreate;

    /**
     * 修改用户
     */
    @ApiModelProperty(value = "修改用户")
    private Long userModified;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    /**
     * 依赖id
     */
    @ApiModelProperty(value = "依赖id")
    private Long dependencyId;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long pid;

    @ApiModelProperty(value = "")
    private Integer permissionCode;

    private static final long serialVersionUID = 1L;
}