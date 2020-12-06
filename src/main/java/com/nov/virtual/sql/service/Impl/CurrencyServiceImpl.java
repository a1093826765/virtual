package com.nov.virtual.sql.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.mapper.CurrencyMapper;
import com.nov.virtual.sql.model.Currency;
import com.nov.virtual.sql.model.CurrencyExample;
import com.nov.virtual.sql.model.CurrencyKey;
import com.nov.virtual.sql.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "CurrencyService")
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired(required = false)
    private CurrencyMapper currencyMapper;

    @Override
    public List<Currency> getCurrencyByExample(CurrencyExample currencyExample) {
        return currencyMapper.selectByExample(currencyExample);
    }

    @Override
    public long getCountByExample(CurrencyExample currencyExample) {
        return currencyMapper.countByExample(currencyExample);
    }

    @Override
    public Currency getCurrencyByKey(CurrencyKey currencyKey) {
        return currencyMapper.selectByPrimaryKey(currencyKey);
    }

    @Override
    public int save(Currency currency) {
        return currencyMapper.insert(currency);
    }

    @Override
    public int deleteByKey(CurrencyKey currencyKey) {
        return currencyMapper.deleteByPrimaryKey(currencyKey);
    }

    @Override
    public int deleteByExampleAll(CurrencyExample currencyExample) {
        return currencyMapper.deleteByExample(currencyExample);
    }

    @Override
    public int updateByKey(Currency currency) {
        return currencyMapper.updateByPrimaryKey(currency);
    }

    @Override
    public int updateByExampleAll(Currency currency, CurrencyExample currencyyExample) {
        return currencyMapper.updateByExample(currency, currencyyExample);
    }

    @Override
    public PageInfo getMenus(Integer page, Integer limit, CurrencyExample currencyExample) {
        PageHelper.startPage(page, limit);
        List<Currency> currencyList = currencyMapper.selectByExample(currencyExample);
        PageInfo<Currency> pageInfo = new PageInfo<Currency>(currencyList);
        return pageInfo;
    }
}
