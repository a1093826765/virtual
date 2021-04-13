package com.nov.virtual.vo.admin.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 删除用户信息api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:57 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "删除用户信息参数",description="/api/admin/user/delete")
public class DeleteUserVirtualVo {

    @ApiModelProperty(value="账号Id",name="userId",required=true)
    private long userId;
}
