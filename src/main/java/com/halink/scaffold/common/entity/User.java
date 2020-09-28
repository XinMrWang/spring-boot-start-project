package com.halink.scaffold.common.entity;

import com.halink.scaffold.common.enumerate.UserStatuesEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "用户表")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "")
    private Long userId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "")
    private String areaCode;
    @ApiModelProperty(value = "")
    private String phone;
    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    private Date registerTime;
    /**
     * 状态：1，正常；2，试用；3，失效
     */
    @ApiModelProperty(value = "状态：1，正常；2，试用；3，失效")
    private UserStatuesEnum status;
    @ApiModelProperty(value = "")
    private Boolean markDeleted;
    /**
     * 最近更新时间
     */
    @ApiModelProperty(value = "最近更新时间")
    private Date gmtModified;
    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;
    @ApiModelProperty(value = "头像")
    private String headPic;
}