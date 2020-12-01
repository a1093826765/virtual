package com.nov.virtual.sql.model;

public class OrderType extends OrderTypeKey {
    private String ordertypename;

    public String getOrdertypename() {
        return ordertypename;
    }

    public void setOrdertypename(String ordertypename) {
        this.ordertypename = ordertypename == null ? null : ordertypename.trim();
    }
}