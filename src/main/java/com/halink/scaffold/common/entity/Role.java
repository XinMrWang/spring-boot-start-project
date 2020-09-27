package com.halink.scaffold.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-halink-scaffold-common-entity-Role")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    /**
     * 角色id
     * <p>
     * 超级管理员
     * owner
     */
    @ApiModelProperty(value = "角色id,,超级管理员,owner,")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "")
    private String roleDesc;

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
     * 权限2进制和
     */
    @ApiModelProperty(value = "权限2进制和")
    private Integer permissionCodeSet;

    private static final long serialVersionUID = 1L;
}