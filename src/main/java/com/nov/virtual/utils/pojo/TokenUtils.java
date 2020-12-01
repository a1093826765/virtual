package com.nov.virtual.utils.pojo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * token工具类
 * @author november
 */
public class TokenUtils {
    /**
     * 生成token
     * 用户id+密钥
     * @param userId
     * @param sec
     * @return
     */
    public static String getToken(Long userId,String sec){
        return JWT.create().withAudience(String.valueOf(userId)).sign(Algorithm.HMAC256(sec));
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean verify(String token,String sec){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(sec)).build();
        try {
            jwtVerifier.verify(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
