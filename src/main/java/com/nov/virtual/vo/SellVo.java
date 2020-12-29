package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 用户卖币参数
 * @author november
 */
@Data
@ApiModel(value = "用户卖币参数",description="/api/web/transaction/sell")
public class SellVo {
    @ApiModelProperty(value="货币数量",name="currencyNum",required=true)
    @NonNull
    private String currencyNum;

    @ApiModelProperty(value="货币名称",name="currencyName",required=true)
    @NonNull
    private String currencyName;
}
