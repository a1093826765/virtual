package com.nov.virtual.sql.model;

public class UserType extends UserTypeKey {
    private String usertypename;

    public String getUsertypename() {
        return usertypename;
    }

    public void setUsertypename(String usertypename) {
        this.usertypename = usertypename == null ? null : usertypename.trim();
    }
}