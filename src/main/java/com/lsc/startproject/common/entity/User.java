package com.lsc.startproject.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String uuid;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 密码
    */
    private String password;

    /**
    * 邮箱
    */
    private String email;

    private String areaCode;

    private String phone;

    /**
    * 注册时间
    */
    private Date registTime;

    /**
    * 状态：1，正常；2，试用；3，失效
    */
    private Byte status;

    private Boolean markDeleted;

    /**
    * 最近更新时间
    */
    private Date gmtModified;

    /**
    * 最后登录时间
    */
    private Date lastLoginTime;

    private String headPic;
}