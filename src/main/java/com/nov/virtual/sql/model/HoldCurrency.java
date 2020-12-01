package com.nov.virtual.sql.model;

public class HoldCurrency extends HoldCurrencyKey {
    private Integer holdcurrencyCurrencyid;

    private String holdcurrencynum;

    private Long holdcurrencyUserid;

    private String holdcurrencymoney;

    public Integer getHoldcurrencyCurrencyid() {
        return holdcurrencyCurrencyid;
    }

    public void setHoldcurrencyCurrencyid(Integer holdcurrencyCurrencyid) {
        this.holdcurrencyCurrencyid = holdcurrencyCurrencyid;
    }

    public String getHoldcurrencynum() {
        return holdcurrencynum;
    }

    public void setHoldcurrencynum(String holdcurrencynum) {
        this.holdcurrencynum = holdcurrencynum == null ? null : holdcurrencynum.trim();
    }

    public Long getHoldcurrencyUserid() {
        return holdcurrencyUserid;
    }

    public void setHoldcurrencyUserid(Long holdcurrencyUserid) {
        this.holdcurrencyUserid = holdcurrencyUserid;
    }

    public String getHoldcurrencymoney() {
        return holdcurrencymoney;
    }

    public void setHoldcurrencymoney(String holdcurrencymoney) {
        this.holdcurrencymoney = holdcurrencymoney == null ? null : holdcurrencymoney.trim();
    }
}