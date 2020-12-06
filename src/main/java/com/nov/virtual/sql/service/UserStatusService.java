package com.nov.virtual.sql.service;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.UserStatus;
import com.nov.virtual.sql.model.UserStatusExample;
import com.nov.virtual.sql.model.UserStatusKey;

import java.util.List;

public interface UserStatusService {
    public List<UserStatus> getUserStatusByExample(UserStatusExample UserStatusExample);
    public long getCountByExample(UserStatusExample UserStatusExample);
    public UserStatus getUserStatusByKey(UserStatusKey UserStatusKey);
    public int save(UserStatus UserStatus);
    public int deleteByKey(UserStatusKey UserStatusKey);
    public int deleteByExampleAll(UserStatusExample UserStatusExample);
    public int updateByKey(UserStatus UserStatus);
    public int updateByExampleAll(UserStatus UserStatus, UserStatusExample UserStatusyExample);
    public PageInfo getMenus(Integer page, Integer limit, UserStatusExample UserStatusExample);
}
