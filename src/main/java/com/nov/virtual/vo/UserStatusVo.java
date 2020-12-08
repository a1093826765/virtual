package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户类型参数
 * @author november
 */
@Data
@ApiModel(value = "用户类型参数",description="/api/admin/userStatus/**")
public class UserStatusVo {

    @ApiModelProperty(value="用户类型Id",name="userStatusId",required=false)
    private Integer userStatusId;

    @ApiModelProperty(value="用户类型",name="userStatusName",required=false)
    private String userStatusName;
}
