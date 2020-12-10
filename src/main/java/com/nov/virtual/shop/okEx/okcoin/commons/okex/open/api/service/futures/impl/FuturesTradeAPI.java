package com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.service.futures.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.futures.param.CancelFuturesOrder;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.futures.param.FuturesOrderParam;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.futures.result.*;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Futures trade api
 *
 * @author Tony Tian
 * @version 1.0.0
 * @date 2018/3/9 19:20
 */
interface FuturesTradeAPI {

    @GET("/api/futures/v3/position")
    Call<JSONObject> getPositions();

    @GET("/api/futures/v3/{instrument_id}/position")
    Call<JSONObject> getInstrumentPosition(@Path("instrument_id") String instrument_id);

    @GET("/api/futures/v3/accounts")
    Call<JSONObject> getAccounts();

    //@GET("/api/futures/v3/accounts/{currency}")
    @GET("/api/futures/v3/accounts/{underlying}")
    Call<JSONObject> getAccountsByCurrency(@Path("underlying") String underlying);
    //账单流水查询
    @GET("/api/futures/v3/accounts/{underlying}/ledger")
    Call<JSONArray> getAccountsLedgerByCurrency(@Path("underlying") String underlying,
                                                @Query("after") String after,
                                                @Query("before") String before,
                                                @Query("limit") String limit,
                                                @Query("type") String type);

    @GET("/api/futures/v3/accounts/{instrument_id}/holds")
    Call<JSONObject> getAccountsHoldsByInstrumentId(@Path("instrument_id") String instrumentId);

    @POST("/api/futures/v3/order")
    Call<OrderResult> order(@Body JSONObject order);

    @POST("/api/futures/v3/orders")
    Call<JSONObject> orders(@Body JSONObject orders);
    //撤销制定订单（根据order_id）
    @POST("/api/futures/v3/cancel_order/{instrument_id}/{order_id}")
    Call<JSONObject> cancelOrderByOrderId(@Path("instrument_id") String instrument_id, @Path("order_id") String order_id);
    //撤销制定订单（根据client_oid）
    @POST("/api/futures/v3/cancel_order/{instrument_id}/{client_oid}")
    Call<JSONObject> cancelOrderByClientOid(@Path("instrument_id") String instrument_id, @Path("client_oid") String client_oid);



    @POST("/api/futures/v3/cancel_batch_orders/{instrument_id}")
    Call<JSONObject> cancelOrders(@Path("instrument_id") String instrumentId, @Body JSONObject order_ids);

    @GET("/api/futures/v3/orders/{instrument_id}")
    Call<JSONObject> getOrders(@Path("instrument_id") String instrumentId, @Query("state") String state,
                               @Query("after") String after, @Query("before") String before, @Query("limit") String limit);
    //获取订单信息（通过orderId）
    @GET("/api/futures/v3/orders/{instrument_id}/{order_id}")
    Call<JSONObject> getOrderByOrderId(@Path("instrument_id") String instrument_id, @Path("order_id") String order_id);
    //获取订单信息（通过client_oid）
    @GET("/api/futures/v3/orders/{instrument_id}/{client_oid}")
    Call<JSONObject> getOrderByClientOid(@Path("instrument_id") String instrument_id, @Path("client_oid") String client_oid);


    //获取成交明细
    @GET("/api/futures/v3/fills")
    Call<JSONArray> getFills(@Query("instrument_id") String instrument_id, @Query("order_id") String order_id,
                             @Query("before") String before, @Query("after") String after, @Query("limit") String limit);

    @GET("/api/futures/v3/accounts/{underlying}/leverage")
    Call<JSONObject> getLeverRate(@Path("underlying") String underlying);

    @POST("/api/futures/v3/accounts/{underlying}/leverage")
    Call<JSONObject> changeLeverageOnFixed(@Path("underlying") String underlying,
                                            @Body JSONObject changeLeverage);

    @POST("/api/futures/v3/accounts/{underlying}/leverage")
    Call<JSONObject> changeLeverageOnCross(@Path("underlying") String underlying,
                                            @Body JSONObject changeLeverage);

    @POST("/api/futures/v3/close_position")
    Call<JSONObject> closePositions(@Body JSONObject closePositions);

    @POST("/api/futures/v3/cancel_all")
    Call<JSONObject> cancelAll(@Body JSONObject cancelAll);

    @POST("/api/futures/v3/accounts/margin_mode")
    Call<JSONObject> changeMarginMode(@Body JSONObject changeMarginMode);

    @POST("/api/futures/v3/accounts/liqui_mode")
    Call<JSONObject> changeLiquiMode(@Body JSONObject changeLiquiMode);

    @POST("api/futures/v3/order_algo")
    Call<FuturesOrderResult> futuresOrder(@Body FuturesOrderParam futuresOrderParam);
    @POST("api/futures/v3/cancel_algos")
    Call<CancelFuturesOrdeResult> cancelFuturesOrder(@Body CancelFuturesOrder cancelFuturesOrder);
    //获取委托单列表
    @GET("api/futures/v3/order_algo/{instrument_id}")
    Call<String> findFuturesOrder(@Path("instrument_id") String instrument_id,
                                      @Query("order_type") String order_type,
                                      @Query("status") String status,
                                      @Query("algo_ids") String algo_ids,
                                      @Query("after") String after,
                                      @Query("before") String before,
                                      @Query("limit") String limit);

    //当前账户交易手续等级的费率
    @GET("/api/futures/v3/trade_fee")
    Call<JSONObject> getTradeFee();

    @GET("/api/futures/v3/accounts/{instrument_id}/holds")
    Call<Holds> getHolds(@Path("instrument_id") String instrument_id);
}