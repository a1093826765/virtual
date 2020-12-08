package com.nov.virtual.sql.service;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualExample;
import com.nov.virtual.sql.model.UserVirtualKey;
import com.nov.virtual.sql.model.UserVirtual;

import java.util.List;

public interface UserVirtualService {
    public List<UserVirtual> getUserByExample(UserVirtualExample userExample);
    public long getCountByExample(UserVirtualExample userExample);
    public UserVirtual getUserByKey(UserVirtualKey userKey);
    public int save(UserVirtual user);
    public int deleteByKey(UserVirtualKey userKey);
    public int deleteByExampleAll(UserVirtualExample userExample);
    public int updateByKey(UserVirtual user);
    public int updateByExampleAll(UserVirtual user, UserVirtualExample useryExample);
    public PageInfo getMenus(Integer page, Integer limit, UserVirtualExample userExample);

    public List<UserVirtual> login(String account,String password);
    public int register(String account,String password,String userName);
    public PageInfo getMenusToUserId(Integer page, Integer limit,long userId);

}
