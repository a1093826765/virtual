package com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.service.spot.impl;

import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.param.MarginLeverage;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.bean.spot.result.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * 杠杆账号测试
 */
public interface MarginAccountAPI {
    /**
     * 全部杠杆资产
     *
     * @return
     */
    @GET("/api/margin/v3/accounts")
    Call<List<Map<String, Object>>> getAccounts();

    /**
     * 单个币对杠杆账号资产
     *
     * @param instrument_id
     * @return
     */
    @GET("/api/margin/v3/accounts/{instrument_id}")
    Call<Map<String, Object>> getAccountsByProductId(@Path("instrument_id") final String instrument_id);

    /**
     * 杠杆账单明细
     *
     * @param instrument_id
     * @param type
     * @param before
     * @param after
     * @param limit
     * @return
     */
    @GET("/api/margin/v3/accounts/{instrument_id}/ledger")
    Call<List<UserMarginBillDto>> getLedger(@Path("instrument_id") final String instrument_id,
                                            @Query("type") final String type,
                                            @Query("before") final String before,
                                            @Query("after") final String after,
                                            @Query("limit") String limit);

    /**
     * 全部币对配置
     *
     * @return
     */
    @GET("/api/margin/v3/accounts/availability")
    Call<List<Map<String, Object>>> getAvailability();

    /**
     * 单个币对配置
     *
     * @param instrument_id
     * @return
     */
    @GET("/api/margin/v3/accounts/{instrument_id}/availability")
    Call<List<Map<String, Object>>> getAvailabilityByProductId(@Path("instrument_id") final String instrument_id);

    /**
     * 全部借币历史
     * @param status
     * @param before
     * @param after
     * @param limit
     * @return
     */
    @GET("/api/margin/v3/accounts/borrowed")
    Call<List<MarginBorrowOrderDto>> getBorrowedAccounts(
            @Query("status") final String status,
            @Query("before") final String before,
            @Query("after") final String after,
            @Query("limit") String limit);

    /**
     * 单个币对借币历史
     * @param status
     * @param before
     * @param after
     * @param limit
     * @param instrument_id
     * @return
     */
    @GET("/api/margin/v3/accounts/{instrument_id}/borrowed")
    Call<List<MarginBorrowOrderDto>> getBorrowedAccountsByProductId(@Path("instrument_id") final String instrument_id,
                                                                    @Query("before") final String before,
                                                                    @Query("after") final String after,
                                                                    @Query("limit") final String limit,
                                                                    @Query("status") final String status);

    /**
     * 借币
     *
     * @param param
     * @return
     */
    @POST("/api/margin/v3/accounts/borrow")
    Call<BorrowResult> borrow_1(@Body BorrowRequestDto param);

    /**
     * 还币
     *
     * @param param
     * @return
     */
    @POST("/api/margin/v3/accounts/repayment")
    Call<RepaymentResult> repayment_1(@Body RepaymentRequestDto param);

    //设置杠杆倍数
    @POST("/api/margin/v3/accounts/{instrument_id}/leverage")
    Call<JSONObject> setLeverage(@Path("instrument_id") String instrument_id, @Body MarginLeverage marginLeverage);

    //查询杠杆倍数
    @GET("/api/margin/v3/accounts/{instrument_id}/leverage")
    Call<JSONObject> getLeverage(@Path("instrument_id") String instrument_id);

}
