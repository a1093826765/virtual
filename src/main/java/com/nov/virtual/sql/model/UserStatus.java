package com.nov.virtual.sql.model;

public class UserStatus extends UserStatusKey {
    private String userstatusname;

    public String getUserstatusname() {
        return userstatusname;
    }

    public void setUserstatusname(String userstatusname) {
        this.userstatusname = userstatusname == null ? null : userstatusname.trim();
    }
}