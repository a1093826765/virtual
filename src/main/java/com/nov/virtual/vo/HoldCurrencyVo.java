package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 添加持有货币api参数
 * @author november
 */
@Data
@ApiModel(value = "持有货币api参数",description="/api/admin/holdCurrency/**")
public class HoldCurrencyVo {

    @ApiModelProperty(value="持有货币Id",name="holdCurrencyId",required=false)
    private long holdCurrencyId;
    
    @ApiModelProperty(value="用户Id",name="userId",required=false)
    private long userId;

    @ApiModelProperty(value="持有货币Id",name="currencyId",required=false)
    private Integer currencyId;

    @ApiModelProperty(value="持有货币数量",name="holdCurrencyNum",required=false)
    private String holdCurrencyNum;

    @ApiModelProperty(value="持有货币购买价",name="holdCurrencyMoney",required=false)
    private String holdCurrencyMoney;
}
