package com.nov.virtual.utils;

import com.nov.virtual.bean.UserVirtualBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static void addUserContext(long userId, String ip, String token) {
        UserContextUtil.clear();
        UserVirtualBean userVirtualBean = new UserVirtualBean();
        userVirtualBean.setIp(ip);
        userVirtualBean.setToken(token);
        userVirtualBean.setUserId(userId);
        context.set(userVirtualBean);
    }

    public static UserVirtualBean getUserVirtualBean() {
        return context.get();
    }

}
