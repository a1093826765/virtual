package com.nov.virtual.bean.resultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 用户状态返回
 * @author november
 */
@Data
public class UserTypeJsonData {
    private Integer userTypeId;
    private String userTypeName;

    public UserTypeJsonData(Integer userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }

    public JSONObject toQueryJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userTypeId",userTypeId);
        jsonObject.put("userTypeName",userTypeName);
        return jsonObject;
    }
}
