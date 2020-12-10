package com.nov.virtual.bean.ResultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;

/**
 * order返回
 * @author november
 */
@Data
public class OrderJsonData {
    private long orderId;
    private Date orderBuyTime;
    private Date orderSellTime;
    private String orderCurrency;
    private String orderCurrencyNum;
    private String orderPrice;
    private String orderType;
    private String orderNumber;
    private String orderStatus;
    private String account;

    public OrderJsonData(long orderId, Date orderBuyTime, Date orderSellTime, String orderCurrency, String orderCurrencyNum, String orderPrice, String orderType, String orderNumber, String orderStatus, String account) {
        this.orderId = orderId;
        this.orderBuyTime = orderBuyTime;
        this.orderSellTime = orderSellTime;
        this.orderCurrency = orderCurrency;
        this.orderCurrencyNum = orderCurrencyNum;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.account = account;
    }

    public JSONObject toQueryJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("orderId",orderId);
        jsonObject.put("orderBuyTime",orderBuyTime);
        jsonObject.put("orderSellTime",orderSellTime);
        jsonObject.put("orderCurrency",orderCurrency);
        jsonObject.put("orderCurrencyNum",orderCurrencyNum);
        jsonObject.put("orderNumber",orderNumber);
        jsonObject.put("orderPrice",orderPrice);
        jsonObject.put("orderType",orderType);
        jsonObject.put("orderStatus",orderStatus);
        jsonObject.put("account",account);
        return jsonObject;
    }
}
