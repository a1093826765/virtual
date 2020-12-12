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
    private String currencyChineName;
    private String currencyImgIcon;

    public CurrencyJsonData(Integer currencyId, String currencyName, String currencyStatus,String currencyChineName,String currencyImgIcon) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.currencyStatus = currencyStatus;
        this.currencyChineName=currencyChineName;
        this.currencyImgIcon=currencyImgIcon;
    }

    public JSONObject toQueryJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("currencyId",currencyId);
        jsonObject.put("currencyName",currencyName);
        jsonObject.put("currencyStatus",currencyStatus);
        jsonObject.put("currencyChineName",currencyChineName);
        jsonObject.put("currencyImgIcon",currencyImgIcon);
        return jsonObject;
    }
}
