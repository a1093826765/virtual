package com.nov.virtual.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.service.OkExService;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: november
 * @CreateTime: 2021/4/6 2:55 下午
 * @UpdateTIme:
 */
@Service
@Slf4j
public class OkExServiceImpl implements OkExService {
    /**
     * Created by IntelliJ IDEA.
     *
     * @return
     * @Description: 获取最新价格
     * @author november
     * @CreateTime: 2021/4/6 2:55 下午
     * @UpdateTIme:
     */
    @Override
    public String getNewMoney(String currencyName) {
        ApiHttp apiHttp = new ApiHttp(new APIConfiguration("https://www.okex.com"), new OkHttpClient());
        String result = apiHttp.get("/api/index/v3/" + currencyName + "-USD/constituents");
        JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
        jsonObject = (JSONObject) JSONObject.parse(jsonObject.getString("data"));
        return jsonObject.getString("last");
    }
}
