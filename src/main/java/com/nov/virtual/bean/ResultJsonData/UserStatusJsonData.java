package com.nov.virtual.bean.ResultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 用户状态返回
 * @author november
 */
@Data
public class UserStatusJsonData {
    private Integer userStatusId;
    private String userStatusName;

    public UserStatusJsonData(Integer userStatusId, String userStatusName) {
        this.userStatusId = userStatusId;
        this.userStatusName = userStatusName;
    }

    public JSONObject toQueryJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userStatusId",userStatusId);
        jsonObject.put("userStatusName",userStatusName);
        return jsonObject;
    }
}
