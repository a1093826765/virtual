package com.nov.virtual.sql.service;

import com.nov.virtual.sql.model.Currency;
import com.nov.virtual.sql.model.CurrencyExample;
import com.nov.virtual.sql.model.CurrencyKey;

import java.util.List;

public interface CurrencyService {
    public List<Currency> getCurrencyByExample(CurrencyExample currencyExample);
    public long getCountByExample(CurrencyExample currencyExample);
    public Currency getCurrencyByKey(CurrencyKey currencyKey);
    public int save(Currency currency);
    public int deleteByKey(CurrencyKey currencyKey);
    public int deleteByExampleAll(CurrencyExample currencyExample);
    public int updateByKey(Currency currency);
    public int updateByExampleAll(Currency currency, CurrencyExample currencyyExample);
    public List<Currency> getMenus(Integer page, Integer limit, CurrencyExample currencyExample);
}
