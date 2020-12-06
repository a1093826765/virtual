package com.nov.virtual.sql.model;

public class CurrencyStatus extends CurrencyStatusKey {
    private String currencystatusname;

    public String getCurrencystatusname() {
        return currencystatusname;
    }

    public void setCurrencystatusname(String currencystatusname) {
        this.currencystatusname = currencystatusname == null ? null : currencystatusname.trim();
    }
}