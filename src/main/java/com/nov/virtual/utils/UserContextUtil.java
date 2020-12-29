package com.nov.virtual.utils;

import com.nov.virtual.bean.UserVirtualBean;
import com.nov.virtual.sql.mapper.UserVirtualMapper;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualKey;
import com.nov.virtual.sql.service.UserVirtualService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用于储存用户的登录信息
 *
 * @author november
 */
public class UserContextUtil {
    public static final Logger logger = LoggerFactory.getLogger(UserContextUtil.class);

    /**
     * 登录用户上下文存储
     */
    private static final ThreadLocal<UserVirtualBean> context = new ThreadLocal<>();

    public static void clear() {
        UserContextUtil.context.remove();
    }

    public void addUserContext(UserVirtual userVirtual, String ip, String token) {
        UserContextUtil.clear();
        UserVirtualBean userVirtualBean = new UserVirtualBean();
        userVirtualBean.setIp(ip);
        userVirtualBean.setToken(token);
        userVirtualBean.setUserVirtual(userVirtual);
        context.set(userVirtualBean);
    }

    public static UserVirtualBean getUserVirtualBean() {
        return context.get();
    }

}
