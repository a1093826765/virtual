package com.nov.virtual.sql.service.Impl;

import com.nov.virtual.sql.mapper.UserVirtualMapper;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualExample;
import com.nov.virtual.sql.model.UserVirtualKey;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.service.UserVirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "UserService")
public class UserVirtualServiceImpl implements UserVirtualService {
    @Autowired(required = false)
    private UserVirtualMapper userMapper;

    @Override
    public List<UserVirtual> getUserByExample(UserVirtualExample userVirtualExample) {
        return userMapper.selectByExample(userVirtualExample);
    }

    @Override
    public long getCountByExample(UserVirtualExample userVirtualExample) {
        return userMapper.countByExample(userVirtualExample);
    }

    @Override
    public UserVirtual getUserByKey(UserVirtualKey userVirtualKey) {
        return userMapper.selectByPrimaryKey(userVirtualKey);
    }

    @Override
    public int save(UserVirtual userVirtual) {
        return userMapper.insert(userVirtual);
    }

    @Override
    public int deleteByKey(UserVirtualKey userVirtualKey) {
        return userMapper.deleteByPrimaryKey(userVirtualKey);
    }

    @Override
    public int deleteByExampleAll(UserVirtualExample userVirtualExample) {
        return userMapper.deleteByExample(userVirtualExample);
    }

    @Override
    public int updateByKey(UserVirtual userVirtual) {
        return userMapper.updateByPrimaryKey(userVirtual);
    }

    @Override
    public int updateByExampleAll(UserVirtual userVirtual, UserVirtualExample userVirtualExample) {
        return userMapper.updateByExample(userVirtual, userVirtualExample);
    }

    @Override
    public List<UserVirtual> getMenus(Integer page, Integer limit, UserVirtualExample userExample) {
        return null;
    }

    @Override
    public List<UserVirtual> login(String account, String password) {
        UserVirtualExample userVirtualExample=new UserVirtualExample();
        UserVirtualExample.Criteria userCriteria=userVirtualExample.createCriteria();
        userCriteria.andAccountEqualTo(account);
        userCriteria.andPasswordEqualTo(password);
        List<UserVirtual> userList=userMapper.selectByExample(userVirtualExample);
        return userList;
    }
}
