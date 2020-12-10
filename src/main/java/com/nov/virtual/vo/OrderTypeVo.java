package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户订单类型参数
 * @author november
 */
@Data
@ApiModel(value = "用户订单类型参数",description="/api/public/orderType/**")
public class OrderTypeVo {

    @ApiModelProperty(value="订单类型Id",name="orderTypeId",required=false)
    private Integer orderTypeId;

    @ApiModelProperty(value="订单类型",name="orderTypeName",required=false)
    private String orderTypeName;
}
