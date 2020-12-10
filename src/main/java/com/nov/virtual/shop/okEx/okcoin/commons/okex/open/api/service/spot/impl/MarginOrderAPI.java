package com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.service.spot.impl;

import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.param.OrderParamDto;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.param.PlaceOrderParam;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.result.Fills;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.result.OrderInfo;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.result.OrderResult;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface MarginOrderAPI {
    /**
     * 单个下单
     *
     * @param param
     * @return
     */
    @POST("api/margin/v3/orders")
    Call<OrderResult> addOrder(@Body PlaceOrderParam param);

    /**
     * 批量下单
     *
     * @param param
     * @return
     */
    @POST("api/margin/v3/batch_orders")
    Call<Map<String, List<OrderResult>>> addOrders(@Body List<PlaceOrderParam> param);

    /**
     * 撤销指定订单
     *
     * @param order_id
     * @param order
     * @return
     */
    @HTTP(method = "DELETE", path = "api/margin/v3/orders/{order_id}", hasBody = true)
    Call<OrderResult> cancleOrdersByProductIdAndOrderId(@Path("order_id") String order_id,
                                                        @Body PlaceOrderParam order);

    /**
     * 撤销指定订单
     *
     * @param order_id
     * @param order
     * @return
     */
    @HTTP(method = "POST", path = "api/margin/v3/cancel_orders/{order_id}", hasBody = true)
    Call<OrderResult> cancleOrdersByOrderId(@Path("order_id") String order_id,
                                            @Body PlaceOrderParam order);

    @HTTP(method = "POST", path = "api/margin/v3/cancel_orders/{client_oid}", hasBody = true)
    Call<OrderResult> cancleOrdersByClientOid(@Path("client_oid") String client_oid,
                                              @Body PlaceOrderParam order);


    /**
     * 批量撤销订单
     *
     * @param cancleOrders
     * @return
     */
    @HTTP(method = "DELETE", path = "api/margin/v3/batch_orders", hasBody = true)
    Call<Map<String, JSONObject>> batchCancleOrders(@Body List<OrderParamDto> cancleOrders);

    /**
     * 批量撤销订单
     *
     * @param cancleOrders
     * @return
     */
    @HTTP(method = "POST", path = "api/margin/v3/cancel_batch_orders", hasBody = true)
    Call<Map<String, Object>> batchCancleOrders_1(@Body List<OrderParamDto> cancleOrders);

    /**
     * 查询指定币对订单
     *
     * @param instrument_id
     * @param order_id
     * @return
     */
    @GET("api/margin/v3/orders/{order_id}")
    Call<OrderInfo> getOrderByProductIdAndOrderId(@Path("order_id") String order_id,
                                                  @Query("instrument_id") String instrument_id);

    @GET("api/margin/v3/orders/{client_oid}")
    Call<OrderInfo> getOrderByClientOid(@Path("client_oid") String client_oid,
                                        @Query("instrument_id") String instrument_id);

    /**
     * 查询订单列表
     *
     * @param instrument_id
     * @param state
     * @param after
     * @param before
     * @param limit
     * @return
     */
    @GET("api/margin/v3/orders")
    Call<List<OrderInfo>> getOrders(@Query("instrument_id") String instrument_id,
                                    @Query("state") String state,
                                    @Query("after") String after,
                                    @Query("before") String before,
                                    @Query("limit") String limit);

    /**
     * 查询挂单列表
     *
     * @param before
     * @param after
     * @param limit
     * @return
     */
    @GET("api/margin/v3/orders_pending")
    Call<List<OrderInfo>> getPendingOrders(@Query("before") String before,
                                           @Query("after") String after,
                                           @Query("limit") String limit,
                                           @Query("instrument_id") String instrument_id);


    @GET("api/margin/v3/fills")
    Call<List<Fills>> getFills(@Query("order_id") String order_id,
                               @Query("instrument_id") String instrument_id,
                               @Query("after") String after,
                               @Query("before") String before,
                               @Query("limit") String limit);
}
