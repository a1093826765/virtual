package com.nov.virtual.websocket;

import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author november
 */
@ServerEndpoint("/webSocket/{sid}")
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

    /**
     * 发送消息
      */
    public static void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
                System.out.println("发送数据：" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }

    /**
     *
     * @param userName
     * @param message
     * 给指定用户发送信息
     */
    public static void sendInfo(String userName, String message){
        Session session = sessionPools.get(userName);
        try {
            sendMessage(session, message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 建立连接成功调用
     * @param session
     * @param userName
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sid") String userName){
        sessionPools.put(userName, session);
        addOnlineCount();
        System.out.println(userName + "加入webSocket！当前人数为" + onlineNum);
        try {
            sendMessage(session, ResultUtils.websocket(ResultCode.CONNECT_SUCCESS).toString());
            sendMessage(session,"开始发送数据--------------->>");
            for(int i=0;i<1000;i++){
                sendMessage(session,"数据包-->"+i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接时调用
     * @param userName
     */
    @OnClose
    public void onClose(@PathParam(value = "sid") String userName){
        sessionPools.remove(userName);
        subOnlineCount();
        System.out.println(userName + "断开webSocket连接！当前人数为" + onlineNum);
    }


    /**
     * 收到客户端信息
     * @param message
     * @param userName
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, @PathParam(value = "sid") String userName) throws IOException{
        message = "客户端：" + message + ",已收到";
        System.out.println(userName+" - "+message);
        sendInfo(userName,message);
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
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }
}
