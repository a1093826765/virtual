package com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.service.spot.impl;

import com.alibaba.fastjson.JSONArray;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.result.*;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.APIClient;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.service.spot.SpotProductAPIService;

import java.util.List;

/**
 * 公共数据相关接口
 *
 **/
public class SpotProductAPIServiceImpl implements SpotProductAPIService {

    private final APIClient client;
    private final SpotProductAPI spotProductAPI;

    public SpotProductAPIServiceImpl(final APIConfiguration config) {
        this.client = new APIClient(config);
        this.spotProductAPI = this.client.createService(SpotProductAPI.class);
    }


    @Override
    public Ticker getTickerByProductId(final String instrument_id) {
        return this.client.executeSync(this.spotProductAPI.getTickerByProductId(instrument_id));
    }

    @Override
    public List<Ticker> getTickers1() {
        return this.client.executeSync(this.spotProductAPI.getTickers1());
    }
    @Override
    public String getTickers() {
        return this.client.executeSync(this.spotProductAPI.getTickers());
    }

    @Override
    public Book bookProductsByProductId(final String instrument_id, final String size, final  String depth) {
        return this.client.executeSync(this.spotProductAPI.bookProductsByProductId(instrument_id, size, depth));
    }

    @Override
    public List<Product> getProducts() {
        return this.client.executeSync(this.spotProductAPI.getProducts());
    }

    @Override
    public List<Trade> getTrades(final String instrument_id,final String limit) {
        return this.client.executeSync(this.spotProductAPI.getTrades(instrument_id,limit));
    }

    @Override
    public JSONArray getCandles(final String instrument_id, final String granularity, final String start, final String end) {
        return this.client.executeSync(this.spotProductAPI.getCandles(instrument_id, granularity, start, end));
    }

    @Override
    public List<String[]> getCandles_1(final String product, final String granularity, final String start, final String end) {
        return this.client.executeSync(this.spotProductAPI.getCandles_1(product, granularity, start, end));
    }

    @Override
    public String getIndex(String instrument_id) {
        return this.client.executeSync(this.spotProductAPI.getIndex(instrument_id));
    }

    @Override
    public String getMarginMarkPrice(String instrument_id) {
        return this.client.executeSync(this.spotProductAPI.getMarginMarkPrice(instrument_id));
    }

}
