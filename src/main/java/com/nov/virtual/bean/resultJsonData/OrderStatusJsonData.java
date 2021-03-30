package com.nov.virtual.bean.resultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 订单状态返回
 * @author november
 */
@Data
public class OrderStatusJsonData {
    private Integer orderStatusId;
    private String orderStatusName;

    public OrderStatusJsonData(Integer orderStatusId, String orderStatusName) {
        this.orderStatusId = orderStatusId;
        this.orderStatusName = orderStatusName;
    }

    public JSONObject toQueryJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("orderStatusId",orderStatusId);
        jsonObject.put("orderStatusName",orderStatusName);
        return jsonObject;
    }
}
