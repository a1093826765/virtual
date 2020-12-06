package com.nov.virtual.sql.model;

public class Currency extends CurrencyKey {
    private String currencyname;

    private Integer currencyCurrencystatusid;

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname == null ? null : currencyname.trim();
    }

    public Integer getCurrencyCurrencystatusid() {
        return currencyCurrencystatusid;
    }

    public void setCurrencyCurrencystatusid(Integer currencyCurrencystatusid) {
        this.currencyCurrencystatusid = currencyCurrencystatusid;
    }
}