package com.nov.virtual.vo.admin.holdCurrency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 删除持有货币api参数
 * @Author: november
 * @CreateTime: 2021/4/10 3:44 下午
 * @UpdateTIme:
 */
@Data
@ApiModel(value = "删除持有货币api参数",description="/api/admin/holdCurrency/delete")
public class DeleteHoldCurrencyVo {

    @ApiModelProperty(value="持有货币Id",name="holdCurrencyId",required=true)
    private long holdCurrencyId;
}
