package com.nov.virtual.sql.model;

public class Currency extends CurrencyKey {
    private String currencyname;

    private Integer currencyCurrencystatusid;

    private String currencyImg;

    private String currencyChinename;

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

    public String getCurrencyImg() {
        return currencyImg;
    }

    public void setCurrencyImg(String currencyImg) {
        this.currencyImg = currencyImg == null ? null : currencyImg.trim();
    }

    public String getCurrencyChinename() {
        return currencyChinename;
    }

    public void setCurrencyChinename(String currencyChinename) {
        this.currencyChinename = currencyChinename == null ? null : currencyChinename.trim();
    }
}