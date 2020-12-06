package com.nov.virtual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 添加可操作货币api参数
 * @author november
 */
@Data
@ApiModel(value = "可操作货币api参数",description="/api/currencyStatus/**")
public class CurrencyStatusVo {
    @ApiModelProperty(value="可操作货币货币Id——删除，修改",name="currencyId",required=false)
    private Integer currencyStatusId;

    @ApiModelProperty(value="可操作货币货币名称——添加，修改",name="currencyName",required=false)
    private String currencyStatusName;

}
