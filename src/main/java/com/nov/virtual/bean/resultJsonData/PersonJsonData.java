package com.nov.virtual.bean.resultJsonData;

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
    private double profitMoney;

    /**
     * 总币数
     */
    private double currencyNumSize;

    /**
     * 个人名称
     */
    private String userName;

    public PersonJsonData(String moneySize, String profit, double profitMoney, double currencyNumSize, String userName) {
        this.moneySize = moneySize;
        this.profit = profit;
        this.profitMoney = profitMoney;
        this.currencyNumSize = currencyNumSize;
        this.userName = userName;
    }

    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("moneySize",moneySize);
        jsonObject.put("profit",profit);
        jsonObject.put("profitMoney",profitMoney);
        jsonObject.put("currencyNumSize",currencyNumSize);
        jsonObject.put("userName",userName);
        return jsonObject;
    }
}
