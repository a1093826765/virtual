package com.nov.virtual.sql.mapper;

import com.nov.virtual.sql.model.UserType;
import com.nov.virtual.sql.model.UserTypeExample;
import com.nov.virtual.sql.model.UserTypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTypeMapper {
    long countByExample(UserTypeExample example);

    int deleteByExample(UserTypeExample example);

    int deleteByPrimaryKey(UserTypeKey key);

    int insert(UserType record);

    int insertSelective(UserType record);

    List<UserType> selectByExample(UserTypeExample example);

    UserType selectByPrimaryKey(UserTypeKey key);

    int updateByExampleSelective(@Param("record") UserType record, @Param("example") UserTypeExample example);

    int updateByExample(@Param("record") UserType record, @Param("example") UserTypeExample example);

    int updateByPrimaryKeySelective(UserType record);

    int updateByPrimaryKey(UserType record);
}