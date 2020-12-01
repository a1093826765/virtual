package com.nov.virtual.sql.model;

public class OrderStatus extends OrderStatusKey {
    private String orderstatusname;

    public String getOrderstatusname() {
        return orderstatusname;
    }

    public void setOrderstatusname(String orderstatusname) {
        this.orderstatusname = orderstatusname == null ? null : orderstatusname.trim();
    }
}