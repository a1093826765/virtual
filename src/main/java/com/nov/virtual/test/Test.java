package com.nov.virtual.test;

import com.nov.virtual.config.Address;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.shop.okEx.okcoin.rest.HttpUtilManager;
import com.nov.virtual.shop.okEx.okcoin.rest.future.IFutureRestApi;
import com.nov.virtual.shop.okEx.okcoin.rest.future.impl.FutureRestApiV1;
import com.nov.virtual.utils.FileUtil;
import com.nov.virtual.utils.pojo.ResultUtils;
import okhttp3.OkHttpClient;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 测试
 *
 * @author november
 */
@Component
@Configurable
@EnableScheduling
public class Test {

    public static void main(String[] args) throws Exception {
//        HashMap<String,String> data=new HashMap<>();
//        data.put("c1","c2");
//        ResultUtils success = ResultUtils.success(data);
//        System.out.println(success);
//        System.out.println(new Date());
//        String api_key = Address.API_KEY;  //OKCoin申请的apiKey
//        String secret_key = Address.SECRET_KEY;  //OKCoin申请的secretKey
//        String url_prex = "https://www.okex.com/";  //注意：请求URL 国际站https://www.okcoin.com ; 国内站https://www.okcoin.cn
//        /**
//         *  get请求无需发送身份认证,通常用于获取行情，市场深度等公共信息
//         */
////        HttpUtilManager httpUtil = HttpUtilManager.getInstance();
//        String result = httpUtil.requestHttpGet(url_prex,"/api/spot/v3/instruments", null);
        int stopDay=0;
        String[] currencys = {"ADA", "LTC", "XRP"};
        int[] mone = {2, 4, 6, 9, 11};
        ApiHttp apiHttp = new ApiHttp(new APIConfiguration("https://www.okex.com"), new OkHttpClient());
        for (String currency : currencys) {
            for (int q = 2010; q <= 2021; q++) {
                for (int i = 1; i <= 12; i++) {
                    a:
                    for (int j = 1; j <= 31; j=j+6) {
                        if (j >= 29 && i == 2) {
                            //排除2月29号
                            break;
                        }
                        for (int n = 0; n < mone.length; n++) {
                            if (j >= 31 && i == mone[n]) {
                                //排除没有31号的月份
                                break a;
                            }
                        }
                        stopDay=j+5;
                        if(j==31){
                            stopDay=31;
                        }
                        if(i==2 &&j==25){
                            stopDay=28;
                        }
                        String result = apiHttp.get(getUrl(currency, q, i, j,stopDay));
                        Thread.sleep(500);
//                        getUrl(currency, q, i, j,stopDay);
//                        String result="[]";
                        if (!result.equals("[]")) {
                            System.out.println(result);
                            FileUtil.writeMethod("/root/apps/txt/virtual/hadoop/" + currency + ".txt", result, true);
                        }
                    }
                    if(q==2021 && i>=5){
                        //最终月份
                        break;
                    }
                }

            }
        }
//        String money="24859.87";
//        String num="0.00000009";
//        String price="23902.968";
//
//        System.out.println(Double.parseDouble(money)-Double.parseDouble(num)*Double.parseDouble(price));
    }

    public static String getUrl(String currency, int year, int mone, int StartDay, int StopDay) {
        String url;
        String m = getMone(mone);
        String StartDayStr = getDay(StartDay);
        String StopDayStr = getDay(StopDay);
        System.out.println("开始时间："+year + "-" + m + "-" + StartDayStr);
        System.out.println("结束时间："+year + "-" + m + "-" + StopDayStr);
        url = "/api/spot/v3/instruments/" + currency + "-USDT/candles?granularity=3600&start=" + year + "-" + m + "-" + StartDayStr + "T00:00:00.000Z&end=" + year + "-" + m + "-" + StopDayStr + "T23:00:00.000Z";
        return url;
    }

    public static String getDay(int day) {
        if (day >= 10) {
            return "" + day;
        }
        return "0" + day;
    }

    public static String getMone(int mone) {
        if (mone < 10) {
            return "0" + mone;
        } else {
            return mone + "";
        }
    }
}
