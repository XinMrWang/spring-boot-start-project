package com.lsc.startproject.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 组,团队
 *
 * @author halink
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    /**
     * 团队id
     */
    private Integer groupId;

    /**
     * 团队名称
     */
    private String groupName;

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
     * 父id
     */
    private Long pid;

    /**
     * 删除标志
     */
    private Boolean markDeleted;
}