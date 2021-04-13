package com.nov.virtual.vo.admin.currency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 修改可操作货币api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:33 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "修改可操作货币api参数",description="/api/public/currency/update")
public class UpdateCurrencyVo {

    @ApiModelProperty(value="可操作货币货币Id",name="currencyId",required=true)
    private Integer currencyId;

    @ApiModelProperty(value="可操作货币货币名称",name="currencyName",required=true)
    private String currencyName;

    @ApiModelProperty(value="可操作货币货状态Id",name="currencyStatusId",required=true)
    private Integer currencyStatusId;

    @ApiModelProperty(value="可操作货币中文名",name="currencyChineName",required=true)
    private String currencyChineName;
}
