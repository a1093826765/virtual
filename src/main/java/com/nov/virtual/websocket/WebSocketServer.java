package com.nov.virtual.websocket;

import com.nov.virtual.shop.okEx.OkExWebSocketClient;
import com.nov.virtual.shop.okEx.OkExWebSocketConfig;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
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
    private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

    private OkExWebSocketClient webSocketClient = new OkExWebSocketClient();


    public static String[] getCurrency(String currency) {
        return currency.split("-");
    }


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
        String[] split = getCurrency(currency);
        String account = split[2];
        Session session = sessionPools.get(account);
        try {
            sendMessage(session, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 建立连接成功调用
     * cuy-BTC,xxx-admin
     *
     * @param session
     * @param currency
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "currency") String currency) {
        String[] split = getCurrency(currency);
        String account = split[2];
        if (sessionPools.get(account) == null) {
            try {
                String currencyName = split[0];
                String[] currencyStr = split[1].split(",");
                sessionPools.put(account, session);
                addOnlineCount();
                System.out.println(account + "加入webSocket！当前人数为" + onlineNum);
                final ArrayList<String> list = new ArrayList<>();
                if ("buy".equals(currencyName)) {
                    for (int i = 0; i < currencyStr.length; i++) {
                        list.add("swap/trade:" + currencyStr[i] + "-USD-SWAP");
                    }
                } else {
                    // currencyName==cuy
                    for (int i = 0; i < currencyStr.length; i++) {
                        list.add("index/ticker:" + currencyStr[i] + "-USD");
                    }
                }
                OkExWebSocketConfig.publicConnect(webSocketClient);
                Thread.sleep(1000);
                webSocketClient.setSession(session);
                webSocketClient.subscribe(list);
                sendMessage(session, ResultUtils.websocket(ResultCodeEnum.CONNECT_SUCCESS).toString());
//                while (okExServicePd.get(account)) {
//                }
//            System.out.println("开始发送数据--------------->>");
//
//            sendMessage(session, "");


            } catch (Exception e) {
                webSocketClient.closeConnection();
                e.printStackTrace();
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
        String[] split = getCurrency(currency);
        String account = split[2];
        if (sessionPools.get(account) != null) {
            sessionPools.remove(account);
            subOnlineCount();
        }
        System.out.println(account + "断开webSocket连接！当前人数为" + onlineNum);
    }


    /**
     * 收到客户端信息
     *
     * @param message
     * @param currency
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, @PathParam(value = "currency") String currency) throws IOException {
        System.out.println(message);
        switch (message){
            case "ping":
                sendInfo(currency, "pong");
                break;
            case "close":
                webSocketClient.setIsConnect(false);
                sendInfo(currency, "ok");
                onClose(currency);
                break;
            default:
                break;
        }
    }
//        System.out.println(currency + " - " + message);
//        sendInfo(account, message);
//        for (Session session: sessionPools.values()) {
//            try {
//                sendMessage(session, message);
//            } catch(Exception e){
//                e.printStackTrace();
//                continue;
//            }
//        }
//    }


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
