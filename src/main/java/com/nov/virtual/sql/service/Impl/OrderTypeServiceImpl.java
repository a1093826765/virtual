package com.nov.virtual.sql.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.mapper.OrderTypeMapper;
import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.OrderType;
import com.nov.virtual.sql.model.OrderTypeExample;
import com.nov.virtual.sql.model.OrderTypeKey;
import com.nov.virtual.sql.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "OrderTypeService")
public class OrderTypeServiceImpl implements OrderTypeService {
    @Autowired(required = false)
    private OrderTypeMapper OrderTypeMapper;

    @Override
    public List<OrderType> getOrderTypeByExample(OrderTypeExample OrderTypeExample) {
        return OrderTypeMapper.selectByExample(OrderTypeExample);
    }

    @Override
    public long getCountByExample(OrderTypeExample OrderTypeExample) {
        return OrderTypeMapper.countByExample(OrderTypeExample);
    }

    @Override
    public OrderType getOrderTypeByKey(OrderTypeKey OrderTypeKey) {
        return OrderTypeMapper.selectByPrimaryKey(OrderTypeKey);
    }

    @Override
    public int save(OrderType OrderType) {
        return OrderTypeMapper.insert(OrderType);
    }

    @Override
    public int deleteByKey(OrderTypeKey OrderTypeKey) {
        return OrderTypeMapper.deleteByPrimaryKey(OrderTypeKey);
    }

    @Override
    public int deleteByExampleAll(OrderTypeExample OrderTypeExample) {
        return OrderTypeMapper.deleteByExample(OrderTypeExample);
    }

    @Override
    public int updateByKey(OrderType OrderType) {
        return OrderTypeMapper.updateByPrimaryKey(OrderType);
    }

    @Override
    public int updateByExampleAll(OrderType OrderType, OrderTypeExample OrderTypeyExample) {
        return OrderTypeMapper.updateByExample(OrderType, OrderTypeyExample);
    }

    @Override
    public PageInfo getMenus(Integer page, Integer limit, OrderTypeExample OrderTypeExample) {
        PageHelper.startPage(page, limit);
        List<OrderType> orderTypeList = OrderTypeMapper.selectByExample(OrderTypeExample);
        PageInfo<OrderType> pageInfo = new PageInfo<OrderType>(orderTypeList);
        return pageInfo;
    }
}
