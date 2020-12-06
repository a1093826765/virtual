package com.nov.virtual.sql.service;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.CurrencyStatus;
import com.nov.virtual.sql.model.CurrencyStatusExample;
import com.nov.virtual.sql.model.CurrencyStatusKey;

import java.util.List;

public interface CurrencyStatusService {
    public List<CurrencyStatus> getCurrencyStatusByExample(CurrencyStatusExample currencyStatusExample);
    public long getCountByExample(CurrencyStatusExample currencyStatusExample);
    public CurrencyStatus getCurrencyStatusByKey(CurrencyStatusKey currencyStatusKey);
    public int save(CurrencyStatus currencyStatus);
    public int deleteByKey(CurrencyStatusKey currencyStatusKey);
    public int deleteByExampleAll(CurrencyStatusExample currencyStatusExample);
    public int updateByKey(CurrencyStatus currencyStatus);
    public int updateByExampleAll(CurrencyStatus currencyStatus, CurrencyStatusExample currencyStatusyExample);
    public PageInfo getMenus(Integer page, Integer limit, CurrencyStatusExample currencyStatusExample);
}
