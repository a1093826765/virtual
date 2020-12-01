package com.nov.virtual.sql.service;

import com.nov.virtual.sql.model.OrderStatus;
import com.nov.virtual.sql.model.OrderStatusExample;
import com.nov.virtual.sql.model.OrderStatusKey;

import java.util.List;

public interface OrderStatusService {
    public List<OrderStatus> getOrderStatusByExample(OrderStatusExample OrderStatusExample);
    public long getCountByExample(OrderStatusExample OrderStatusExample);
    public OrderStatus getOrderStatusByKey(OrderStatusKey OrderStatusKey);
    public int save(OrderStatus OrderStatus);
    public int deleteByKey(OrderStatusKey OrderStatusKey);
    public int deleteByExampleAll(OrderStatusExample OrderStatusExample);
    public int updateByKey(OrderStatus OrderStatus);
    public int updateByExampleAll(OrderStatus OrderStatus, OrderStatusExample OrderStatusyExample);
    public List<OrderStatus> getMenus(Integer page, Integer limit, OrderStatusExample OrderStatusExample);
}
