package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户类型参数
 * @author november
 */
@Data
@ApiModel(value = "用户类型参数",description="/api/admin/userType/**")
public class UserTypeVo {

    @ApiModelProperty(value="用户类型Id",name="userTypeId",required=false)
    private Integer userTypeId;

    @ApiModelProperty(value="用户类型",name="userTypeName",required=false)
    private String userTypeName;
}
