package com.nov.virtual.sql.mapper;

import com.nov.virtual.sql.model.UserStatus;
import com.nov.virtual.sql.model.UserStatusExample;
import com.nov.virtual.sql.model.UserStatusKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStatusMapper {
    long countByExample(UserStatusExample example);

    int deleteByExample(UserStatusExample example);

    int deleteByPrimaryKey(UserStatusKey key);

    int insert(UserStatus record);

    int insertSelective(UserStatus record);

    List<UserStatus> selectByExample(UserStatusExample example);

    UserStatus selectByPrimaryKey(UserStatusKey key);

    int updateByExampleSelective(@Param("record") UserStatus record, @Param("example") UserStatusExample example);

    int updateByExample(@Param("record") UserStatus record, @Param("example") UserStatusExample example);

    int updateByPrimaryKeySelective(UserStatus record);

    int updateByPrimaryKey(UserStatus record);
}