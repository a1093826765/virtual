package com.nov.virtual.sql.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.mapper.CurrencyStatusMapper;
import com.nov.virtual.sql.model.CurrencyStatus;
import com.nov.virtual.sql.model.CurrencyStatusExample;
import com.nov.virtual.sql.model.CurrencyStatusKey;
import com.nov.virtual.sql.service.CurrencyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "CurrencyStatusService")
public class CurrencyStatusServiceImpl implements CurrencyStatusService {
    @Autowired(required = false)
    private CurrencyStatusMapper CurrencyStatusMapper;

    @Override
    public List<CurrencyStatus> getCurrencyStatusByExample(CurrencyStatusExample CurrencyStatusExample) {
        return CurrencyStatusMapper.selectByExample(CurrencyStatusExample);
    }

    @Override
    public long getCountByExample(CurrencyStatusExample CurrencyStatusExample) {
        return CurrencyStatusMapper.countByExample(CurrencyStatusExample);
    }

    @Override
    public CurrencyStatus getCurrencyStatusByKey(CurrencyStatusKey CurrencyStatusKey) {
        return CurrencyStatusMapper.selectByPrimaryKey(CurrencyStatusKey);
    }

    @Override
    public int save(CurrencyStatus CurrencyStatus) {
        return CurrencyStatusMapper.insert(CurrencyStatus);
    }

    @Override
    public int deleteByKey(CurrencyStatusKey CurrencyStatusKey) {
        return CurrencyStatusMapper.deleteByPrimaryKey(CurrencyStatusKey);
    }

    @Override
    public int deleteByExampleAll(CurrencyStatusExample CurrencyStatusExample) {
        return CurrencyStatusMapper.deleteByExample(CurrencyStatusExample);
    }

    @Override
    public int updateByKey(CurrencyStatus CurrencyStatus) {
        return CurrencyStatusMapper.updateByPrimaryKey(CurrencyStatus);
    }

    @Override
    public int updateByExampleAll(CurrencyStatus CurrencyStatus, CurrencyStatusExample CurrencyStatusyExample) {
        return CurrencyStatusMapper.updateByExample(CurrencyStatus, CurrencyStatusyExample);
    }

    @Override
    public PageInfo getMenus(Integer page, Integer limit, CurrencyStatusExample CurrencyStatusExample) {
        PageHelper.startPage(page, limit);
        List<CurrencyStatus> CurrencyStatusList = CurrencyStatusMapper.selectByExample(CurrencyStatusExample);
        PageInfo<CurrencyStatus> pageInfo = new PageInfo<CurrencyStatus>(CurrencyStatusList);
        return pageInfo;
    }
}
