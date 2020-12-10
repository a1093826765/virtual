package com.nov.virtual.websocket;

import com.nov.virtual.shop.okEx.OkExWebSocketClient;
import com.nov.virtual.shop.okEx.OkExWebSocketConfig;
import com.nov.virtual.shop.okEx.OkExWebSocketStart;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import org.junit.Before;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author november
 */
@ServerEndpoint("/webSocket/{currency}")
@Component
public class WebSocketServer {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicInteger onlineNum = new AtomicInteger();

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
     */
    public static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, Boolean> okExServicePd = new ConcurrentHashMap<>();


    /**
     * 发送消息
     */
    public static void sendMessage(Session session, String message) throws IOException {
        if (session != null) {
            synchronized (session) {
//                System.out.println("发送数据：" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }

    /**
     * @param currency
     * @param message  给指定用户发送信息
     */
    public static void sendInfo(String currency, String message) {
        Session session = sessionPools.get(currency);
        try {
            sendMessage(session, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 建立连接成功调用
     *
     * @param session
     * @param currency
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "currency") String currency) {
        if (sessionPools.get(currency) == null) {
            sessionPools.put(currency, session);
            addOnlineCount();
            System.out.println(currency + "加入webSocket！当前人数为" + onlineNum);
            try {
                String currencyName=currency.substring(0,3);
                final ArrayList<String> list = new ArrayList<>();
                if ("buy".equals(currencyName)) {
                    currencyName = currency.substring(3, 6);
                    list.add("spot/trade:" + currencyName + "-USD-SWAP");
                } else {
                    list.add("index/ticker:" + currencyName + "-USD");
                }
                OkExWebSocketClient webSocketClient = new OkExWebSocketClient();
                OkExWebSocketConfig.publicConnect(webSocketClient);
                webSocketClient.setSession(session);
                webSocketClient.subscribe(list);
                okExServicePd.put(currency, true);
                sendMessage(session, ResultUtils.websocket(ResultCode.CONNECT_SUCCESS).toString());
                while (okExServicePd.get(currency)) {
                }
//            System.out.println("开始发送数据--------------->>");
//
//            sendMessage(session, "");


            } catch (Exception e) {
//            e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接时调用
     *
     * @param currency
     */
    @OnClose
    public void onClose(@PathParam(value = "currency") String currency) {

        if (sessionPools.get(currency) != null) {
            sessionPools.remove(currency);
            subOnlineCount();
            okExServicePd.put(currency, false);
        }
        System.out.println(currency + "断开webSocket连接！当前人数为" + onlineNum);
    }


    /**
     * 收到客户端信息
     *
     * @param message
     * @param userName
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, @PathParam(value = "currency") String userName) throws IOException {
        message = "客户端：" + message + ",已收到";
        System.out.println(userName + " - " + message);
        sendInfo(userName, message);
//        for (Session session: sessionPools.values()) {
//            try {
//                sendMessage(session, message);
//            } catch(Exception e){
//                e.printStackTrace();
//                continue;
//            }
//        }
    }


    /**
     * 错误时调用
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount() {
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }
}
