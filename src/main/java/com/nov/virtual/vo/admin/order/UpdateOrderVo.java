package com.nov.virtual.vo.admin.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 修改订单api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:50 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "修改用户订单参数",description="/api/admin/order/update")
public class UpdateOrderVo {
    @ApiModelProperty(value="订单Id",name="holdCurrencyId",required=true)
    private long orderId;

    @ApiModelProperty(value="订单号",name="orderNum",required=true)
    private String orderNum;

    @ApiModelProperty(value="订单价值",name="orderPrice",required=true)
    private String orderPrice;

    @ApiModelProperty(value="订单类型Id",name="orderTypeId",required=true)
    private Integer orderTypeId;

    @ApiModelProperty(value="订单状态Id",name="orderStatusId",required=true)
    private Integer orderStatusId;
    
    @ApiModelProperty(value="订单货币Id",name="orderCurrencyId",required=true)
    private Integer orderCurrencyId;

    @ApiModelProperty(value="订单货币数量",name="orderCurrencyNum",required=true)
    private String orderCurrencyNum;

    @ApiModelProperty(value="账号",name="account",required=true)
    private String account;
}
