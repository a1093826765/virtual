package com.nov.virtual.sql.mapper;

import com.nov.virtual.sql.model.OrderType;
import com.nov.virtual.sql.model.OrderTypeExample;
import com.nov.virtual.sql.model.OrderTypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTypeMapper {
    long countByExample(OrderTypeExample example);

    int deleteByExample(OrderTypeExample example);

    int deleteByPrimaryKey(OrderTypeKey key);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    List<OrderType> selectByExample(OrderTypeExample example);

    OrderType selectByPrimaryKey(OrderTypeKey key);

    int updateByExampleSelective(@Param("record") OrderType record, @Param("example") OrderTypeExample example);

    int updateByExample(@Param("record") OrderType record, @Param("example") OrderTypeExample example);

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);
}