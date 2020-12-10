package com.nov.virtual.bean.ResultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 货币返回
 *
 * @author november
 */
@Data
public class CurrencyJsonData {
    private Integer currencyId;
    private String currencyName;
    private String currencyStatus;

    public CurrencyJsonData(Integer currencyId, String currencyName, String currencyStatus) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.currencyStatus = currencyStatus;
    }

    public JSONObject toQueryJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("currencyId",currencyId);
        jsonObject.put("currencyName",currencyName);
        jsonObject.put("currencyStatus",currencyStatus);
        return jsonObject;
    }
}
