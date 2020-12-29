package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * Created by IntelliJ IDEA.
 * 货币最新价api参数
 * @Author: november
 * Date: 2020/12/23 4:08 下午
 */
@Data
@ApiModel(value = "用户买币参数",description="/api/web/newMoney")
public class CurrencyNewMoencyVo {
    @ApiModelProperty(value="货币名称",name="currencyName",required=true)
    @NonNull
    private String currencyName;
}
