package com.lsc.startproject.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Group {
    /**
    * 团队id
    */
    private String groupId;

    /**
    * 团队名称
    */
    private String groupName;

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

    /**
    * 父id
    */
    private String pid;

    /**
    * 删除标志
    */
    private Boolean markDeleted;
}