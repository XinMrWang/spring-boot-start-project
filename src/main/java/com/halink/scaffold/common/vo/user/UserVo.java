package com.halink.scaffold.common.vo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.halink.scaffold.common.enumerate.UserStatuesEnum;
import com.halink.scaffold.config.enumserialize.CustomListEnumDeserialize;
import com.halink.scaffold.config.enumserialize.CustomListEnumSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * 用于给前端部分用户信息
 *
 * @author LiKeshuang
 * @date 2020/9/25 2:53 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "nmd不能为空")
    private String username;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "区号")
    private String areaCode;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "状态：1，正常；2，试用；3，失效")
    @JsonSerialize(using = CustomListEnumSerializer.class)
    @JsonDeserialize(using = CustomListEnumDeserialize.class)
    private List<UserStatuesEnum> status;
    @ApiModelProperty(value = "最后登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;
    @ApiModelProperty(value = "头像")
    private String headPic;
}
