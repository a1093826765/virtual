package com.nov.virtual.vo.admin.currency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 删除可操作货币api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:30 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "删除可操作货币api参数",description="/api/public/currency/insert")
public class DeleteCurrencyVo {

    @ApiModelProperty(value="可操作货币货币Id",name="currencyId",required=true)
    private Integer currencyId;

}
