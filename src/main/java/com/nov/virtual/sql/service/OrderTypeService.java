package com.nov.virtual.sql.service;

import com.nov.virtual.sql.model.OrderType;
import com.nov.virtual.sql.model.OrderTypeExample;
import com.nov.virtual.sql.model.OrderTypeKey;

import java.util.List;

public interface OrderTypeService {
    public List<OrderType> getOrderTypeByExample(OrderTypeExample OrderTypeExample);
    public long getCountByExample(OrderTypeExample OrderTypeExample);
    public OrderType getOrderTypeByKey(OrderTypeKey OrderTypeKey);
    public int save(OrderType OrderType);
    public int deleteByKey(OrderTypeKey OrderTypeKey);
    public int deleteByExampleAll(OrderTypeExample OrderTypeExample);
    public int updateByKey(OrderType OrderType);
    public int updateByExampleAll(OrderType OrderType, OrderTypeExample OrderTypeyExample);
    public List<OrderType> getMenus(Integer page, Integer limit, OrderTypeExample OrderTypeExample);
}
