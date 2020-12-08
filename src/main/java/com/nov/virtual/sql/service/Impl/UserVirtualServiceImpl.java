package com.nov.virtual.sql.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.mapper.UserVirtualMapper;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.service.UserVirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public PageInfo getMenus(Integer page, Integer limit, UserVirtualExample userExample) {
        PageHelper.startPage(page, limit);
        List<UserVirtual> userVirtualList = userMapper.selectByExample(userExample);
        PageInfo<UserVirtual> pageInfo = new PageInfo<UserVirtual>(userVirtualList);
        return pageInfo;
    }

    /**
     * 验证账号密码
     * @param account
     * @param password
     * @return
     */
    @Override
    public List<UserVirtual> login(String account, String password) {
        UserVirtualExample userVirtualExample=new UserVirtualExample();
        UserVirtualExample.Criteria userCriteria=userVirtualExample.createCriteria();
        userCriteria.andAccountEqualTo(account);
        userCriteria.andPasswordEqualTo(password);
        return userMapper.selectByExample(userVirtualExample);
    }

    /**
     * 注册
     * @param account
     * @param password
     * @param userName
     * @return
     */
    @Override
    public int register(String account, String password, String userName) {
        UserVirtual userVirtual=new UserVirtual();
        userVirtual.setAccount(account);
        userVirtual.setMoney("0");
        userVirtual.setPassword(password);
        userVirtual.setUsername(userName);
        // 1：启用，2：禁用，3：异常
        userVirtual.setUserUserstautsid(1);
        // 1：普通用户，2：管理员
        userVirtual.setUserUsertypeid(1);
        userVirtual.setRegistertime(new Date());
        return userMapper.insert(userVirtual);
    }

    @Override
    public PageInfo getMenusToUserId(Integer page, Integer limit, long userId) {
        UserVirtualExample userVirtualExample=new UserVirtualExample();
        UserVirtualExample.Criteria criteria=userVirtualExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        return this.getMenus(page, limit, userVirtualExample);
    }
}
