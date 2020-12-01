package com.nov.virtual.sql.model;

import java.util.Date;

public class UserVirtual extends UserVirtualKey {
    private String account;

    private String password;

    private Date registertime;

    private String username;

    private String money;

    private Integer userUserstautsid;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public Integer getUserUserstautsid() {
        return userUserstautsid;
    }

    public void setUserUserstautsid(Integer userUserstautsid) {
        this.userUserstautsid = userUserstautsid;
    }
}