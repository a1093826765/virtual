package com.nov.virtual.vo.admin.holdCurrency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 查询持有货币api参数
 * @author november
 */
@Data
@ApiModel(value = "查询持有货币api参数",description="/api/admin/holdCurrency/query")
public class QueryHoldCurrencyVo {

    @ApiModelProperty(value="用户Id",name="userId",required=true)
    private long userId;
}
