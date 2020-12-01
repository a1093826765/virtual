package com.nov.virtual.sql.service.Impl;

import com.nov.virtual.sql.mapper.HoldCurrencyMapper;
import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.HoldCurrencyExample;
import com.nov.virtual.sql.model.HoldCurrencyKey;
import com.nov.virtual.sql.service.HoldCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "HoldCurrencyService")
public class HoldCurrencyServiceImpl implements HoldCurrencyService {
    @Autowired(required = false)
    private HoldCurrencyMapper HoldCurrencyMapper;

    @Override
    public List<HoldCurrency> getHoldCurrencyByExample(HoldCurrencyExample HoldCurrencyExample) {
        return HoldCurrencyMapper.selectByExample(HoldCurrencyExample);
    }

    @Override
    public long getCountByExample(HoldCurrencyExample HoldCurrencyExample) {
        return HoldCurrencyMapper.countByExample(HoldCurrencyExample);
    }

    @Override
    public HoldCurrency getHoldCurrencyByKey(HoldCurrencyKey HoldCurrencyKey) {
        return HoldCurrencyMapper.selectByPrimaryKey(HoldCurrencyKey);
    }

    @Override
    public int save(HoldCurrency HoldCurrency) {
        return HoldCurrencyMapper.insert(HoldCurrency);
    }

    @Override
    public int deleteByKey(HoldCurrencyKey HoldCurrencyKey) {
        return HoldCurrencyMapper.deleteByPrimaryKey(HoldCurrencyKey);
    }

    @Override
    public int deleteByExampleAll(HoldCurrencyExample HoldCurrencyExample) {
        return HoldCurrencyMapper.deleteByExample(HoldCurrencyExample);
    }

    @Override
    public int updateByKey(HoldCurrency HoldCurrency) {
        return HoldCurrencyMapper.updateByPrimaryKey(HoldCurrency);
    }

    @Override
    public int updateByExampleAll(HoldCurrency HoldCurrency, HoldCurrencyExample HoldCurrencyyExample) {
        return HoldCurrencyMapper.updateByExample(HoldCurrency, HoldCurrencyyExample);
    }

    @Override
    public List<HoldCurrency> getMenus(Integer page, Integer limit, HoldCurrencyExample HoldCurrencyExample) {
        return null;
    }
}
