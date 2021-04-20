package com.nov.virtual.vo.admin.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 添加用户订单api参数
 * @author november
 */
@Data
@ApiModel(value = "添加用户订单参数",description="/api/admin/order/insert")
public class InsertOrderVo {

    @ApiModelProperty(value="订单号",name="orderNum",required=true)
    private String orderNum;

    @ApiModelProperty(value="订单价值",name="orderPrice",required=true)
    private String orderPrice;

    @ApiModelProperty(value="订单类型Id",name="orderTypeId",required=true)
    private Integer orderTypeId;

    @ApiModelProperty(value="订单状态Id",name="orderStatusId",required=true)
    private Integer orderStatusId;

    @ApiModelProperty(value="账号",name="account",required=true)
    private String  account;

    @ApiModelProperty(value="订单货币Id",name="orderCurrencyId",required=true)
    private Integer orderCurrencyId;

    @ApiModelProperty(value="订单货币数量",name="orderCurrencyNum",required=true)
    private String orderCurrencyNum;

}
