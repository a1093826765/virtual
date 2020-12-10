package com.nov.virtual.bean.ResultJsonData;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 订单类型返回
 * @author november
 */
@Data
public class OrderTypeJsonData {
    private Integer orderTypeId;
    private String orderTypeName;

    public OrderTypeJsonData(Integer orderTypeId, String orderTypeName) {
        this.orderTypeId = orderTypeId;
        this.orderTypeName = orderTypeName;
    }

    public JSONObject toQueryJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("orderTypeId",orderTypeId);
        jsonObject.put("orderTypeName",orderTypeName);
        return jsonObject;
    }
}