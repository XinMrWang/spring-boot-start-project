package com.halink.scaffold.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-halink-scaffold-common-entity-Group")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group implements Serializable {
    /**
     * 团队id
     */
    @ApiModelProperty(value = "团队id")
    private Long groupId;

    /**
     * 团队名称
     */
    @ApiModelProperty(value = "团队名称")
    private String groupName;

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
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long pid;

    /**
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志")
    private Boolean markDeleted;

    private static final long serialVersionUID = 1L;
}