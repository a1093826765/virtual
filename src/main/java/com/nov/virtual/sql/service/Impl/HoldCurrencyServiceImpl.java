package com.nov.virtual.sql.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.mapper.CurrencyMapper;
import com.nov.virtual.sql.mapper.HoldCurrencyMapper;
import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.HoldCurrencyExample;
import com.nov.virtual.sql.model.HoldCurrencyKey;
import com.nov.virtual.sql.service.HoldCurrencyService;
import com.nov.virtual.vo.admin.holdCurrency.InsertHoldCurrencyVo;
import com.nov.virtual.vo.admin.holdCurrency.QueryHoldCurrencyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "HoldCurrencyService")
public class HoldCurrencyServiceImpl implements HoldCurrencyService {
    @Autowired(required = false)
    private HoldCurrencyMapper HoldCurrencyMapper;

    @Autowired(required = false)
    private CurrencyMapper currencyMapper;

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
    public PageInfo getMenus(Integer page, Integer limit, HoldCurrencyExample HoldCurrencyExample) {
        PageHelper.startPage(page, limit);
        List<HoldCurrency> holdCurrencyList = HoldCurrencyMapper.selectByExample(HoldCurrencyExample);
        PageInfo<HoldCurrency> pageInfo = new PageInfo<HoldCurrency>(holdCurrencyList);
        return pageInfo;
    }

    /**
     * 分页查询对应的用户持有货币信息
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public PageInfo getMenusToUserId(Integer page, Integer limit, long userId) {
        HoldCurrencyExample holdCurrencyExample=new HoldCurrencyExample();
        HoldCurrencyExample.Criteria criteria=holdCurrencyExample.createCriteria();
        criteria.andHoldcurrencyUseridEqualTo(userId);
        PageInfo pageInfo = this.getMenus(page, limit, holdCurrencyExample);
        return pageInfo;
    }

    /**
     * api添加数据
     * @param insertHoldCurrencyVo
     * @return
     */
    @Override
    public int insert(InsertHoldCurrencyVo insertHoldCurrencyVo) {
        try {
            HoldCurrencyExample holdCurrencyExample = new HoldCurrencyExample();
            holdCurrencyExample.createCriteria().andHoldcurrencyCurrencyidEqualTo(insertHoldCurrencyVo.getCurrencyId())
                    .andHoldcurrencyUseridEqualTo(insertHoldCurrencyVo.getUserId());
            List<HoldCurrency> holdCurrencyList = this.getHoldCurrencyByExample(holdCurrencyExample);
            HoldCurrency holdCurrency = new HoldCurrency();
            if (holdCurrencyList.size() > 0) {
                holdCurrency=holdCurrencyList.get(0);
                double money=Double.parseDouble(holdCurrency.getHoldcurrencymoney()) + Double.parseDouble(insertHoldCurrencyVo.getHoldCurrencyMoney());
                double num=Double.parseDouble(holdCurrency.getHoldcurrencynum()) + Double.parseDouble(insertHoldCurrencyVo.getHoldCurrencyNum());
                holdCurrency.setHoldcurrencymoney(String.valueOf(money));
                holdCurrency.setHoldcurrencynum(String.valueOf(num));
                return this.updateByKey(holdCurrency);
            } else {
                holdCurrency.setHoldcurrencyCurrencyid(insertHoldCurrencyVo.getCurrencyId());
                holdCurrency.setHoldcurrencymoney(insertHoldCurrencyVo.getHoldCurrencyMoney());
                holdCurrency.setHoldcurrencynum(insertHoldCurrencyVo.getHoldCurrencyNum());
                holdCurrency.setHoldcurrencyUserid(insertHoldCurrencyVo.getUserId());
                return this.save(holdCurrency);
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


}
