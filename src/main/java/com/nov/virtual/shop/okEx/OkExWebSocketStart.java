package com.nov.virtual.shop.okEx;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * okExWebSocket启动
 * @author november
 */
public class OkExWebSocketStart {
    private static final OkExWebSocketClient webSocketClient = new OkExWebSocketClient();

    private boolean webSocketPd=true;

    @Before
    public void connect() {
        OkExWebSocketConfig.publicConnect(webSocketClient);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openUSDA(String currency){
        final ArrayList<String> list = new ArrayList<>();
        list.add("index/ticker:"+currency+"-USD");
        webSocketClient.subscribe(list);
        while(webSocketPd){

        }
    }

    public void setWebSocketPd(boolean webSocketPd) {
        this.webSocketPd = webSocketPd;
    }

    /**
     * option/candle60s // 1分钟K线数据频道
     *
     * option/candle180s // 3分钟K线数据频道
     *
     * option/candle300s // 5分钟K线数据频道
     *
     * option/candle900s // 15分钟K线数据频道
     *
     * option/candle1800s // 30分钟K线数据频道
     *
     * option/candle3600s // 1小时K线数据频道
     *
     * option/candle7200s // 2小时K线数据频道
     *
     * option/candle14400s // 4小时K线数据频道
     *
     * option/candle21600 // 6小时K线数据频道
     *
     * option/candle43200s // 12小时K线数据频道
     *
     * option/candle86400s // 1dayK线数据频道
     *
     * option/candle604800s // 1week K线数据频道
     */
    @Test
    public void wsStart() {
        //创建一个list集合，添加要订阅的频道名称
        final ArrayList<String> list = new ArrayList<>();
//        list.add("index/ticker:BTC-USD");
//        list.add("index/candle86400s:BTC-USD");
//        list.add("spot/ticker:ETH-USDT");
//        list.add("spot/candle60s:BTC-USDT");
//        list.add("spot/candle180s:ETH-USDT");
//        list.add("spot/depth5:BTC-USDT");
//        list.add("spot/depth5:ETH-USDT");
        list.add("spot/trade:ETH-USDT");
        // 公共交易频道
//        list.add("swap/trade:BTC-USD-SWAP");
        webSocketClient.subscribe(list);
        //为保证测试方法不停，需要让线程延迟
//        try {
//            Thread.sleep(10000000);
//        } catch (final Exception e) {
//            e.printStackTrace();
//        }
        while(true){

        }
    }
}
