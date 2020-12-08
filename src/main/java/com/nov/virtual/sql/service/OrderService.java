package com.nov.virtual.sql.service;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.Order;
import com.nov.virtual.sql.model.OrderExample;
import com.nov.virtual.sql.model.OrderKey;

import java.util.List;

public interface OrderService {
    public List<Order> getOrderByExample(OrderExample orderExample);
    public long getCountByExample(OrderExample orderExample);
    public Order getOrderByKey(OrderKey orderKey);
    public int save(Order order);
    public int deleteByKey(OrderKey orderKey);
    public int deleteByExampleAll(OrderExample orderExample);
    public int updateByKey(Order order);
    public int updateByExampleAll(Order order, OrderExample orderyExample);
    public PageInfo getMenus(Integer page, Integer limit, OrderExample orderExample);

    public PageInfo getMenusToUserId(Integer page, Integer limit,long userId);
}
