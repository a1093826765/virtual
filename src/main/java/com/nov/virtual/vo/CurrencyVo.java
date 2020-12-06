package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 添加可操作货币api参数
 * @author november
 */
@Data
@ApiModel(value = "可操作货币api参数（除查询）",description="/api/currency/**")
public class CurrencyVo {

    @ApiModelProperty(value="可操作货币货币Id——删除，修改",name="currencyId",required=false)
    private Integer currencyId;

    @ApiModelProperty(value="可操作货币货币名称——添加，修改",name="currencyName",required=false)
    private String currencyName;

    @ApiModelProperty(value="可操作货币货状态Id——添加，修改",name="currencyStatusId",required=false)
    private Integer currencyStatusId;
}
