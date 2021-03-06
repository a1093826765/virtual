package com.nov.virtual.sql.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.mapper.OrderMapper;
import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.Order;
import com.nov.virtual.sql.model.OrderExample;
import com.nov.virtual.sql.model.OrderKey;
import com.nov.virtual.sql.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrderByExample(OrderExample orderExample) {
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public long getCountByExample(OrderExample orderExample) {
        return orderMapper.countByExample(orderExample);
    }

    @Override
    public Order getOrderByKey(OrderKey orderKey) {
        return orderMapper.selectByPrimaryKey(orderKey);
    }

    @Override
    public int save(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int deleteByKey(OrderKey orderKey) {
        return orderMapper.deleteByPrimaryKey(orderKey);
    }

    @Override
    public int deleteByExampleAll(OrderExample orderExample) {
        return orderMapper.deleteByExample(orderExample);
    }

    @Override
    public int updateByKey(Order order) {
        return orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public int updateByExampleAll(Order order, OrderExample orderyExample) {
        return orderMapper.updateByExample(order, orderyExample);
    }

    @Override
    public PageInfo getMenus(Integer page, Integer limit, OrderExample orderExample) {
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return  new PageInfo<Order>(orderList);
    }

    @Override
    public PageInfo getMenusToUserId(Integer page, Integer limit, long userId) {
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria=orderExample.createCriteria();
        criteria.andOrderUseridEqualTo(userId);
        return this.getMenus(page, limit, orderExample);
    }
}
