package com.nov.virtual.sql.service;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.UserType;
import com.nov.virtual.sql.model.UserTypeExample;
import com.nov.virtual.sql.model.UserTypeKey;

import java.util.List;

public interface UserTypeService {
    public List<UserType> getUserTypeByExample(UserTypeExample UserTypeExample);
    public long getCountByExample(UserTypeExample UserTypeExample);
    public UserType getUserTypeByKey(UserTypeKey UserTypeKey);
    public int save(UserType UserType);
    public int deleteByKey(UserTypeKey UserTypeKey);
    public int deleteByExampleAll(UserTypeExample UserTypeExample);
    public int updateByKey(UserType UserType);
    public int updateByExampleAll(UserType UserType, UserTypeExample UserTypeyExample);
    public PageInfo getMenus(Integer page, Integer limit, UserTypeExample UserTypeExample);
}
