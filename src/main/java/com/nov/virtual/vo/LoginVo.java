package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;
import lombok.Data;

/**
 * 存储用户登录信息
 * @author november
 */

@Data
@ApiModel(value = "用户登录参数",description="/api/login")
public class LoginVo {

    @ApiModelProperty(value="账号",name="account",required=true)
    @NonNull
    private String account;

    @ApiModelProperty(value="密码",name="password",required=true)
    @NonNull
    private String password;
}
