package com.nov.virtual.bean.ResultJsonData;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;

/**
 * userVirtual返回
 * @author november
 */
@Data
public class UserVirtualJsonData {
    
    private long userId;
    private String account;
    private String password;
    private Date registerTime;
    private String userName;
    private String money;
    private String userStatus;
    private String userType;

    public UserVirtualJsonData(long userId, String account, String password, Date registerTime, String userName, String money, String userStatus, String userType) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.registerTime = registerTime;
        this.userName = userName;
        this.money = money;
        this.userStatus = userStatus;
        this.userType = userType;
    }

    public JSONObject toQueryJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId", userId);
        jsonObject.put("account", account);
        jsonObject.put("password", password);
        jsonObject.put("registerTime", registerTime);
        jsonObject.put("userName", userName);
        jsonObject.put("money", money);
        jsonObject.put("userStatus", userStatus);
        jsonObject.put("userType", userType);
        return jsonObject;
    }
}
