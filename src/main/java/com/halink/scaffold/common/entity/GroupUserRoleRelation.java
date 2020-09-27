package com.halink.scaffold.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-halink-scaffold-common-entity-GroupUserRoleRelation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupUserRoleRelation implements Serializable {
    /**
     * 群组id
     */
    @ApiModelProperty(value = "群组id")
    private Long groupId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 角色id
     * role_id = 0 owner 为群主
     */
    @ApiModelProperty(value = "角色id,role_id = 0 owner 为群主")
    private Long roleId;

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