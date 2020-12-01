package com.nov.virtual.sql.service.Impl;

import com.nov.virtual.sql.mapper.OrderStatusMapper;
import com.nov.virtual.sql.model.OrderStatus;
import com.nov.virtual.sql.model.OrderStatusExample;
import com.nov.virtual.sql.model.OrderStatusKey;
import com.nov.virtual.sql.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "OrderStatusService")
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired(required = false)
    private OrderStatusMapper OrderStatusMapper;

    @Override
    public List<OrderStatus> getOrderStatusByExample(OrderStatusExample OrderStatusExample) {
        return OrderStatusMapper.selectByExample(OrderStatusExample);
    }

    @Override
    public long getCountByExample(OrderStatusExample OrderStatusExample) {
        return OrderStatusMapper.countByExample(OrderStatusExample);
    }

    @Override
    public OrderStatus getOrderStatusByKey(OrderStatusKey OrderStatusKey) {
        return OrderStatusMapper.selectByPrimaryKey(OrderStatusKey);
    }

    @Override
    public int save(OrderStatus OrderStatus) {
        return OrderStatusMapper.insert(OrderStatus);
    }

    @Override
    public int deleteByKey(OrderStatusKey OrderStatusKey) {
        return OrderStatusMapper.deleteByPrimaryKey(OrderStatusKey);
    }

    @Override
    public int deleteByExampleAll(OrderStatusExample OrderStatusExample) {
        return OrderStatusMapper.deleteByExample(OrderStatusExample);
    }

    @Override
    public int updateByKey(OrderStatus OrderStatus) {
        return OrderStatusMapper.updateByPrimaryKey(OrderStatus);
    }

    @Override
    public int updateByExampleAll(OrderStatus OrderStatus, OrderStatusExample OrderStatusyExample) {
        return OrderStatusMapper.updateByExample(OrderStatus, OrderStatusyExample);
    }

    @Override
    public List<OrderStatus> getMenus(Integer page, Integer limit, OrderStatusExample OrderStatusExample) {
        return null;
    }
}
