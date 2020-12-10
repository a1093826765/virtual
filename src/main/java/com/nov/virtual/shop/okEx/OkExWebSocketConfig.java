package com.nov.virtual.shop.okEx;


import com.nov.virtual.config.Address;

/**
 * 加载okEx配置
 * @author november
 */
public class OkExWebSocketConfig {


    public static void publicConnect(OkExWebSocketClient webSocketClient) {
        webSocketClient.connection(Address.SERVICE_URL);
    }

    public static void loginConnect(OkExWebSocketClient webSocketClient) {
        //与服务器建立连接
        webSocketClient.connection(Address.SERVICE_URL);
        //登录账号,用户需提供 api-key，passphrase,secret—key 不要随意透漏 ^_^
        webSocketClient.login(Address.API_KEY , Address.PASSPHRASE , Address.SECRET_KEY);
    }
}
