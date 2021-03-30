package com.nov.virtual.bean.resultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 货币状态返回
 * @author november
 */
@Data
public class CurrencyStatusJsonData {
    private Integer currencyStatusId;
    private String currencyName;

    public CurrencyStatusJsonData(Integer currencyStatusId, String currencyName) {
        this.currencyStatusId = currencyStatusId;
        this.currencyName = currencyName;
    }

    public JSONObject toQueryJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("currencyStatusId",currencyStatusId);
        jsonObject.put("currencyName",currencyName);
        return jsonObject;
    }
}
