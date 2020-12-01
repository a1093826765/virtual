package com.nov.virtual.sql.service.Impl;

import com.nov.virtual.sql.mapper.UserStatusMapper;
import com.nov.virtual.sql.model.UserStatus;
import com.nov.virtual.sql.model.UserStatusExample;
import com.nov.virtual.sql.model.UserStatusKey;
import com.nov.virtual.sql.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service(value = "UserStatusService")
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired(required = false)
    private UserStatusMapper UserStatusMapper;

    @Override
    public List<UserStatus> getUserStatusByExample(UserStatusExample UserStatusExample) {
        return UserStatusMapper.selectByExample(UserStatusExample);
    }

    @Override
    public long getCountByExample(UserStatusExample UserStatusExample) {
        return UserStatusMapper.countByExample(UserStatusExample);
    }

    @Override
    public UserStatus getUserStatusByKey(UserStatusKey UserStatusKey) {
        return UserStatusMapper.selectByPrimaryKey(UserStatusKey);
    }

    @Override
    public int save(UserStatus UserStatus) {
        return UserStatusMapper.insert(UserStatus);
    }

    @Override
    public int deleteByKey(UserStatusKey UserStatusKey) {
        return UserStatusMapper.deleteByPrimaryKey(UserStatusKey);
    }

    @Override
    public int deleteByExampleAll(UserStatusExample UserStatusExample) {
        return UserStatusMapper.deleteByExample(UserStatusExample);
    }

    @Override
    public int updateByKey(UserStatus UserStatus) {
        return UserStatusMapper.updateByPrimaryKey(UserStatus);
    }

    @Override
    public int updateByExampleAll(UserStatus UserStatus, UserStatusExample UserStatusyExample) {
        return UserStatusMapper.updateByExample(UserStatus, UserStatusyExample);
    }

    @Override
    public List<UserStatus> getMenus(Integer page, Integer limit, UserStatusExample UserStatusExample) {
        return null;
    }
}
