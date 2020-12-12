package com.nov.virtual.interceptor;

import com.nov.virtual.sql.mapper.UserVirtualMapper;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualKey;
import com.nov.virtual.utils.UserContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author november
 */
public class AdminInterceptor implements HandlerInterceptor {

    private static final Integer ADMIN_ID=2;

    @Autowired(required = false)
    private UserVirtualMapper userVirtualMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("后端拦截器");
        try {
            Long userId = UserContextUtil.getUserVirtualBean().getUserId();
            UserVirtualKey userVirtualKey = new UserVirtualKey();
            userVirtualKey.setUserid(Long.valueOf(userId));
            UserVirtual userVirtual = userVirtualMapper.selectByPrimaryKey(userVirtualKey);
            if (userVirtual == null || !userVirtual.getUserUsertypeid().equals(ADMIN_ID)) {
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
