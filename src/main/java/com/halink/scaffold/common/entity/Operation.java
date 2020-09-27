package com.halink.scaffold.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-halink-scaffold-common-entity-Operation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operation implements Serializable {
    @ApiModelProperty(value = "")
    private Long operationId;

    /**
     * 操作名称
     */
    @ApiModelProperty(value = "操作名称")
    private String operationName;

    @ApiModelProperty(value = "")
    private String operationDesc;

    /**
     * 请求路径
     */
    @ApiModelProperty(value = "请求路径")
    private String requestUrl;

    @ApiModelProperty(value = "")
    private Long permissionId;

    /**
     * 接口注解
     */
    @ApiModelProperty(value = "接口注解")
    private String perm;

    @ApiModelProperty(value = "")
    private String route;

    /**
     * 0路由,1按钮
     */
    @ApiModelProperty(value = "0路由,1按钮")
    private Byte type;

    @ApiModelProperty(value = "")
    private Integer operationCode;

    private static final long serialVersionUID = 1L;
}