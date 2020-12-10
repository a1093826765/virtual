package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户订单状态参数
 * @author november
 */
@Data
@ApiModel(value = "用户订单状态参数",description="/api/public/orderStatus/**")
public class OrderStatusVo {

    @ApiModelProperty(value="订单状态Id",name="orderStatusId",required=false)
    private Integer orderStatusId;

    @ApiModelProperty(value="订单状态",name="orderStatusName",required=false)
    private String orderStatusName;
}
