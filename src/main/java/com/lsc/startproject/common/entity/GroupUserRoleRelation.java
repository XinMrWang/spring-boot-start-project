package com.lsc.startproject.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 * 组,用户,角色关系
 * @author halink
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupUserRoleRelation {
    /**
    * 群组id
    */
    private Long groupId;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 角色id
role_id = 0 owner 为群主
    */
    private Long roleId;

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