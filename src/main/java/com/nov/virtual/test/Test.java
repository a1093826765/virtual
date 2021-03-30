package com.nov.virtual.test;

import com.nov.virtual.config.Address;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.shop.okEx.okcoin.rest.HttpUtilManager;
import com.nov.virtual.shop.okEx.okcoin.rest.future.IFutureRestApi;
import com.nov.virtual.shop.okEx.okcoin.rest.future.impl.FutureRestApiV1;
import com.nov.virtual.utils.pojo.ResultUtils;
import okhttp3.OkHttpClient;
import org.apache.http.HttpException;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * 测试
 * @author november
 */
public class Test {
    public static void main(String[] args) throws IOException, HttpException {
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
        ApiHttp apiHttp=new ApiHttp(new APIConfiguration("https://www.okex.com"),new OkHttpClient());
        String result=apiHttp.get("/api/spot/v3/instruments/BTC-USDT/candles?granularity=60");
        System.out.println(result);
//        String money="24859.87";
//        String num="0.00000009";
//        String price="23902.968";
//
//        System.out.println(Double.parseDouble(money)-Double.parseDouble(num)*Double.parseDouble(price));
    }
}
