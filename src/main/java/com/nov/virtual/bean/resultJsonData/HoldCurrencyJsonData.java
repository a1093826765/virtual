package com.nov.virtual.bean.resultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 持有货币返回
 *
 * @author november
 */
@Data
public class HoldCurrencyJsonData {
    private long holdCurrencyId;
    private String holdCurrencyMoney;
    private String holdCurrencyNum;
    private String currency;

    public HoldCurrencyJsonData(long holdCurrencyId, String holdCurrencyMoney, String holdCurrencyNum, String currency) {
        this.holdCurrencyId = holdCurrencyId;
        this.holdCurrencyMoney = holdCurrencyMoney;
        this.holdCurrencyNum = holdCurrencyNum;
        this.currency = currency;
    }

    public JSONObject toQueryJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("holdCurrencyId",holdCurrencyId);
        jsonObject.put("holdCurrencyMoney",holdCurrencyMoney);
        jsonObject.put("holdCurrencyNum",holdCurrencyNum);
        jsonObject.put("currency",currency);
        return jsonObject;
    }
}
