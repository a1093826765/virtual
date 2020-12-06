package com.nov.virtual.sql.mapper;

import com.nov.virtual.sql.model.CurrencyStatus;
import com.nov.virtual.sql.model.CurrencyStatusExample;
import com.nov.virtual.sql.model.CurrencyStatusKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurrencyStatusMapper {
    long countByExample(CurrencyStatusExample example);

    int deleteByExample(CurrencyStatusExample example);

    int deleteByPrimaryKey(CurrencyStatusKey key);

    int insert(CurrencyStatus record);

    int insertSelective(CurrencyStatus record);

    List<CurrencyStatus> selectByExample(CurrencyStatusExample example);

    CurrencyStatus selectByPrimaryKey(CurrencyStatusKey key);

    int updateByExampleSelective(@Param("record") CurrencyStatus record, @Param("example") CurrencyStatusExample example);

    int updateByExample(@Param("record") CurrencyStatus record, @Param("example") CurrencyStatusExample example);

    int updateByPrimaryKeySelective(CurrencyStatus record);

    int updateByPrimaryKey(CurrencyStatus record);
}