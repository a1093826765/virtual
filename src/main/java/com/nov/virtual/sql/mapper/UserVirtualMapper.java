package com.nov.virtual.sql.mapper;

import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualExample;
import com.nov.virtual.sql.model.UserVirtualKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVirtualMapper {
    long countByExample(UserVirtualExample example);

    int deleteByExample(UserVirtualExample example);

    int deleteByPrimaryKey(UserVirtualKey key);

    int insert(UserVirtual record);

    int insertSelective(UserVirtual record);

    List<UserVirtual> selectByExample(UserVirtualExample example);

    UserVirtual selectByPrimaryKey(UserVirtualKey key);

    int updateByExampleSelective(@Param("record") UserVirtual record, @Param("example") UserVirtualExample example);

    int updateByExample(@Param("record") UserVirtual record, @Param("example") UserVirtualExample example);

    int updateByPrimaryKeySelective(UserVirtual record);

    int updateByPrimaryKey(UserVirtual record);
}