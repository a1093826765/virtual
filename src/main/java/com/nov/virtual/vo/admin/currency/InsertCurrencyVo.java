package com.nov.virtual.vo.admin.currency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 添加可操作货币api参数
 * @author november
 */
@Data
@ApiModel(value = "添加可操作货币api参数",description="/api/public/currency/insert")
public class InsertCurrencyVo {

    @ApiModelProperty(value="可操作货币货币名称",name="currencyName",required=true)
    private String currencyName;

    @ApiModelProperty(value="可操作货币货状态Id",name="currencyStatusId",required=true)
    private Integer currencyStatusId;

    @ApiModelProperty(value="可操作货币中文名",name="currencyChineName",required=true)
    private String currencyChineName;
}
