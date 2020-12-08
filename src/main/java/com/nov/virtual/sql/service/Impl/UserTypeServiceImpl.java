package com.nov.virtual.sql.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.mapper.UserTypeMapper;
import com.nov.virtual.sql.model.UserType;
import com.nov.virtual.sql.model.UserTypeExample;
import com.nov.virtual.sql.model.UserTypeKey;
import com.nov.virtual.sql.service.UserTypeService;
import com.nov.virtual.sql.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "UserTypeService")
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired(required = false)
    private com.nov.virtual.sql.mapper.UserTypeMapper UserTypeMapper;

    @Override
    public List<UserType> getUserTypeByExample(UserTypeExample UserTypeExample) {
        return UserTypeMapper.selectByExample(UserTypeExample);
    }

    @Override
    public long getCountByExample(UserTypeExample UserTypeExample) {
        return UserTypeMapper.countByExample(UserTypeExample);
    }

    @Override
    public UserType getUserTypeByKey(UserTypeKey UserTypeKey) {
        return UserTypeMapper.selectByPrimaryKey(UserTypeKey);
    }

    @Override
    public int save(UserType UserType) {
        return UserTypeMapper.insert(UserType);
    }

    @Override
    public int deleteByKey(UserTypeKey UserTypeKey) {
        return UserTypeMapper.deleteByPrimaryKey(UserTypeKey);
    }

    @Override
    public int deleteByExampleAll(UserTypeExample UserTypeExample) {
        return UserTypeMapper.deleteByExample(UserTypeExample);
    }

    @Override
    public int updateByKey(UserType UserType) {
        return UserTypeMapper.updateByPrimaryKey(UserType);
    }

    @Override
    public int updateByExampleAll(UserType UserType, UserTypeExample UserTypeyExample) {
        return UserTypeMapper.updateByExample(UserType, UserTypeyExample);
    }

    @Override
    public PageInfo getMenus(Integer page, Integer limit, UserTypeExample UserTypeExample) {
        PageHelper.startPage(page, limit);
        List<UserType> userTypeList = UserTypeMapper.selectByExample(UserTypeExample);
        PageInfo<UserType> pageInfo = new PageInfo<UserType>(userTypeList);
        return pageInfo;
    }
}

