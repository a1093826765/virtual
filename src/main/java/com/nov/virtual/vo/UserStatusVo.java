package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户状态参数
 * @author november
 */
@Data
@ApiModel(value = "用户状态参数",description="/api/admin/userStatus/**")
public class UserStatusVo {

    @ApiModelProperty(value="用户状态Id",name="userStatusId",required=false)
    private Integer userStatusId;

    @ApiModelProperty(value="用户状态",name="userStatusName",required=false)
    private String userStatusName;
}
