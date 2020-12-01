package com.nov.virtual.sql.model;

public class Currency extends CurrencyKey {
    private String currencyname;

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname == null ? null : currencyname.trim();
    }
}