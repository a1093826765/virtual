package com.nov.virtual.vo.admin.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 添加用户信息api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:57 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "添加用户信息参数",description="/api/admin/user/insert")
public class InsertUserVirtualVo {

    @ApiModelProperty(value="账号",name="account",required=true)
    private String account;

    @ApiModelProperty(value="密码",name="password",required=true)
    private String password;

    @ApiModelProperty(value="用户名",name="userName",required=true)
    private String userName;

    @ApiModelProperty(value="余额",name="money",required=true)
    private String money;

    @ApiModelProperty(value="用户状态Id",name="userStatusId",required=true)
    private Integer userStatusId;

    @ApiModelProperty(value="用户类型Id",name="userTypeId",required=true)
    private Integer userTypeId;
}
