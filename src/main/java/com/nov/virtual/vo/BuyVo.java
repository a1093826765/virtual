package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 用户买币参数
 * @author november
 */
@Data
@ApiModel(value = "用户买币参数",description="/api/web/transaction/buy")
public class BuyVo {
    @ApiModelProperty(value="货币数量",name="money",required=true)
    @NonNull
    private double money;

    @ApiModelProperty(value="货币名称",name="currencyName",required=true)
    @NonNull
    private String currencyName;
}
