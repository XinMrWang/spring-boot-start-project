package com.lsc.startproject.common.entity;

import java.util.Date;
import lombok.Data;

@Data
public class GroupUserRoleRelation {
    /**
    * 群组id
    */
    private String groupId;

    /**
    * 用户id
    */
    private String userId;

    /**
    * 角色id
role_id = 0 owner 为群主
    */
    private String roleId;

    /**
    * 创建用户
    */
    private String userCreate;

    /**
    * 修改用户
    */
    private String userModified;

    /**
    * 创建时间
    */
    private Date gmtCreate;

    /**
    * 修改时间
    */
    private Date gmtModified;
}