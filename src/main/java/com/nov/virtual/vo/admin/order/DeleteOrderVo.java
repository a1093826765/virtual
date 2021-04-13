package com.nov.virtual.vo.admin.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 删除订单api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:50 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "修改用户订单参数",description="/api/admin/order/delete")
public class DeleteOrderVo {

    @ApiModelProperty(value="订单Id",name="holdCurrencyId",required=false)
    private long orderId;
}
