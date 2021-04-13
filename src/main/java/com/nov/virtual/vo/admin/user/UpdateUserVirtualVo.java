package com.nov.virtual.vo.admin.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 修改用户信息api参数
 * @author november
 */
@Data
@ApiModel(value = "修改用户信息参数",description="/api/admin/user/update")
public class UpdateUserVirtualVo {

    @ApiModelProperty(value="账号Id",name="userId",required=true)
    private long userId;

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
