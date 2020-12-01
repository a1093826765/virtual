package com.nov.virtual.vo;

import lombok.Data;

/**
 * 存储用户登录信息
 * @author november
 */

@Data
public class LoginVo {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
