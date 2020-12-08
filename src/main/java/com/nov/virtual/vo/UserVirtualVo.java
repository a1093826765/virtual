package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 存储用户注册信息
 * @author november
 */
@Data
@ApiModel(value = "用户注册参数",description="/api/register")
public class UserVirtualVo {

    @ApiModelProperty(value="账号",name="userId",required=false)
    private long userId;

    @ApiModelProperty(value="账号",name="account",required=false)
    private String account;

    @ApiModelProperty(value="密码",name="password",required=false)
    private String password;

    @ApiModelProperty(value="用户名",name="userName",required=false)
    private String userName;

    @ApiModelProperty(value="余额",name="money",required=false)
    private String money;

    @ApiModelProperty(value="用户状态Id",name="userStatusId",required=false)
    private Integer userStatusId;

    @ApiModelProperty(value="用户类型Id",name="userTypeId",required=false)
    private Integer userTypeId;
}
