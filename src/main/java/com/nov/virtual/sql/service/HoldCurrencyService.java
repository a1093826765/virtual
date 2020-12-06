package com.nov.virtual.sql.service;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.HoldCurrencyExample;
import com.nov.virtual.sql.model.HoldCurrencyKey;

import java.util.List;

public interface HoldCurrencyService {
    public List<HoldCurrency> getHoldCurrencyByExample(HoldCurrencyExample HoldCurrencyExample);
    public long getCountByExample(HoldCurrencyExample HoldCurrencyExample);
    public HoldCurrency getHoldCurrencyByKey(HoldCurrencyKey HoldCurrencyKey);
    public int save(HoldCurrency HoldCurrency);
    public int deleteByKey(HoldCurrencyKey HoldCurrencyKey);
    public int deleteByExampleAll(HoldCurrencyExample HoldCurrencyExample);
    public int updateByKey(HoldCurrency HoldCurrency);
    public int updateByExampleAll(HoldCurrency HoldCurrency, HoldCurrencyExample HoldCurrencyyExample);
    public PageInfo getMenus(Integer page, Integer limit, HoldCurrencyExample HoldCurrencyExample);
}
