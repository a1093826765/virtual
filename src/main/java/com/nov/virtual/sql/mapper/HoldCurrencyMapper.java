package com.nov.virtual.sql.mapper;

import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.HoldCurrencyExample;
import com.nov.virtual.sql.model.HoldCurrencyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HoldCurrencyMapper {
    long countByExample(HoldCurrencyExample example);

    int deleteByExample(HoldCurrencyExample example);

    int deleteByPrimaryKey(HoldCurrencyKey key);

    int insert(HoldCurrency record);

    int insertSelective(HoldCurrency record);

    List<HoldCurrency> selectByExample(HoldCurrencyExample example);

    HoldCurrency selectByPrimaryKey(HoldCurrencyKey key);

    int updateByExampleSelective(@Param("record") HoldCurrency record, @Param("example") HoldCurrencyExample example);

    int updateByExample(@Param("record") HoldCurrency record, @Param("example") HoldCurrencyExample example);

    int updateByPrimaryKeySelective(HoldCurrency record);

    int updateByPrimaryKey(HoldCurrency record);
}