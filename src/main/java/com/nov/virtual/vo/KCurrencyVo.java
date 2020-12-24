package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * Created by IntelliJ IDEA.
 * 货币K线
 * @Author: november
 * Date: 2020/12/21
 */
@Data
@ApiModel(value = "货币K线参数",description="/api/web/KCurrency")
public class KCurrencyVo {
    @ApiModelProperty(value="开始时间",name="startTime",required=false)
    private String startTime;

    @ApiModelProperty(value="接送时间",name="stopTime",required=false)
    private String stopTime;

    @ApiModelProperty(value="K线类",name="granularity",required=true)
    @NonNull
    private Integer granularity;

    @ApiModelProperty(value="货币名称",name="currencyName",required=true)
    @NonNull
    private String currencyName;
}
