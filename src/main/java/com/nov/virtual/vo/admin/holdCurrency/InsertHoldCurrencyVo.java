package com.nov.virtual.vo.admin.holdCurrency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 添加持有货币api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:44 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "添加持有货币api参数",description="/api/admin/holdCurrency/insert")
public class InsertHoldCurrencyVo {
    @ApiModelProperty(value="持有货币Id",name="holdCurrencyId",required=true)
    private long holdCurrencyId;

    @ApiModelProperty(value="货币Id",name="currencyId",required=true)
    private Integer currencyId;

    @ApiModelProperty(value="持有货币数量",name="holdCurrencyNum",required=true)
    private String holdCurrencyNum;

    @ApiModelProperty(value="持有货币购买价",name="holdCurrencyMoney",required=true)
    private String holdCurrencyMoney;

    @ApiModelProperty(value="用户Id",name="userId",required=true)
    private long userId;
}
