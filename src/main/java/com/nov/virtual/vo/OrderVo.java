package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 存储用户订单信息
 * @author november
 */
@Data
@ApiModel(value = "用户订单参数",description="/api/admin/order/**")
public class OrderVo {

    @ApiModelProperty(value="持有货币Id",name="holdCurrencyId",required=false)
    private long orderId;

    @ApiModelProperty(value="订单号",name="orderNum",required=false)
    private String orderNum;

    @ApiModelProperty(value="订单价值",name="orderPrice",required=false)
    private String orderPrice;

    @ApiModelProperty(value="订单类型Id",name="orderTypeId",required=false)
    private Integer orderTypeId;

    @ApiModelProperty(value="订单状态Id",name="orderStatusId",required=false)
    private Integer orderStatusId;

    @ApiModelProperty(value="订单用户Id",name="orderUserId",required=false)
    private long orderUserId;

    @ApiModelProperty(value="订单货币Id",name="orderCurrencyId",required=false)
    private Integer orderCurrencyId;

    @ApiModelProperty(value="订单货币数量",name="orderCurrencyNum",required=false)
    private String orderCurrencyNum;

}
