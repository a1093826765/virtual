package com.nov.virtual.interceptor;

import com.auth0.jwt.JWT;
import com.nov.virtual.sql.mapper.UserVirtualMapper;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualKey;
import com.nov.virtual.config.Address;
import com.nov.virtual.utils.NetworkUtil;
import com.nov.virtual.utils.UserContextUtil;
import com.nov.virtual.utils.pojo.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截器
 * @author november
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired(required = false)
    private UserVirtualMapper userVirtualMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("token拦截器");
        String token=request.getHeader("Authorization");
//        System.out.println(token);
        if(token==null){
            // token为空,用户未登录
            // response.sendRedirect("");
            return false;
        }
        String userId;
        try{
            // 获取userId
            userId= JWT.decode(token).getAudience().get(0);
            UserVirtualKey userVirtualKey=new UserVirtualKey();
            userVirtualKey.setUserid(Long.valueOf(userId));
            UserVirtual userVirtual=userVirtualMapper.selectByPrimaryKey(userVirtualKey);
            if(userVirtual==null){
                // 用户不存在
                // response.sendRedirect("");
                return false;
            }
            // 校验token
            if(TokenUtils.verify(token, Address.TOKEN_SEC)){
                UserContextUtil userContextUtil=new UserContextUtil();
                userContextUtil.addUserContext(userVirtual, NetworkUtil.getIPAddress(request),token);
                return true;
            }
            // response.sendRedirect("");
            return false;
        }catch (Exception e){
            // token错误（userId不存在 或者 token验证失败）
            // response.sendRedirect("");
            e.printStackTrace();
        }
        return false;
    }
}
