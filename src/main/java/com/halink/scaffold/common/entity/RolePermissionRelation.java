package com.halink.scaffold.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-halink-scaffold-common-entity-RolePermissionRelation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionRelation implements Serializable {
    @ApiModelProperty(value = "")
    private Long roleId;

    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private Long permissionId;

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

    private static final long serialVersionUID = 1L;
}