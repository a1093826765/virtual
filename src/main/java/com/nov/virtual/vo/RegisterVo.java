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
@ApiModel(value = "用户注册参数",description="/api/web/register")
public class RegisterVo {
    @NonNull
    @ApiModelProperty(value="账号",name="account",required=true)
    private String account;

    @NonNull
    @ApiModelProperty(value="密码",name="password",required=true)
    private String password;

    @NonNull
    @ApiModelProperty(value="用户名",name="userName",required=true)
    private String userName;
}
