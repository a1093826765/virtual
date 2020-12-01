package com.nov.virtual.sql.mapper;

import com.nov.virtual.sql.model.Currency;
import com.nov.virtual.sql.model.CurrencyExample;
import com.nov.virtual.sql.model.CurrencyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurrencyMapper {
    long countByExample(CurrencyExample example);

    int deleteByExample(CurrencyExample example);

    int deleteByPrimaryKey(CurrencyKey key);

    int insert(Currency record);

    int insertSelective(Currency record);

    List<Currency> selectByExample(CurrencyExample example);

    Currency selectByPrimaryKey(CurrencyKey key);

    int updateByExampleSelective(@Param("record") Currency record, @Param("example") CurrencyExample example);

    int updateByExample(@Param("record") Currency record, @Param("example") CurrencyExample example);

    int updateByPrimaryKeySelective(Currency record);

    int updateByPrimaryKey(Currency record);
}