package com.nov.virtual.sql.model;

import java.util.Date;

public class Order extends OrderKey {
    private String ordernumber;

    private Date orderbuytime;

    private Date orderselltime;

    private String orderprice;

    private Integer orderTypeid;

    private Integer orderStatusid;

    private Long orderUserid;

    private Integer orderCurrencyid;

    private String orderCurrencynum;

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    public Date getOrderbuytime() {
        return orderbuytime;
    }

    public void setOrderbuytime(Date orderbuytime) {
        this.orderbuytime = orderbuytime;
    }

    public Date getOrderselltime() {
        return orderselltime;
    }

    public void setOrderselltime(Date orderselltime) {
        this.orderselltime = orderselltime;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice == null ? null : orderprice.trim();
    }

    public Integer getOrderTypeid() {
        return orderTypeid;
    }

    public void setOrderTypeid(Integer orderTypeid) {
        this.orderTypeid = orderTypeid;
    }

    public Integer getOrderStatusid() {
        return orderStatusid;
    }

    public void setOrderStatusid(Integer orderStatusid) {
        this.orderStatusid = orderStatusid;
    }

    public Long getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Long orderUserid) {
        this.orderUserid = orderUserid;
    }

    public Integer getOrderCurrencyid() {
        return orderCurrencyid;
    }

    public void setOrderCurrencyid(Integer orderCurrencyid) {
        this.orderCurrencyid = orderCurrencyid;
    }

    public String getOrderCurrencynum() {
        return orderCurrencynum;
    }

    public void setOrderCurrencynum(String orderCurrencynum) {
        this.orderCurrencynum = orderCurrencynum == null ? null : orderCurrencynum.trim();
    }
}