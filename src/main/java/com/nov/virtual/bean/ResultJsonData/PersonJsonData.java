package com.nov.virtual.bean.ResultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * 个人信息返回
 * @Author: november
 * Date: 2020/12/28 11:05 上午
 */
@Data
public class PersonJsonData {
    /**
     * 总资产
     */
    private String moneySize;

    /**
     * 收益
     */
    private String profit;

    /**
     * 收益金额
     */
    private String profitMoney;

    /**
     * 总币数
     */
    private double currencyNumSize;

    public PersonJsonData(String moneySize, String profit, String profitMoney, double currencyNumSize) {
        this.moneySize = moneySize;
        this.profit = profit;
        this.profitMoney = profitMoney;
        this.currencyNumSize = currencyNumSize;
    }

    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("moneySize",moneySize);
        jsonObject.put("profit",profit);
        jsonObject.put("profitMoney",profitMoney);
        jsonObject.put("currencyNumSize",currencyNumSize);
        return jsonObject;
    }
}
