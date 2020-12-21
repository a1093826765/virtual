package com.nov.virtual.controller.web;

import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.KCurrencyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: november
 * Date: 2020/12/21
 */
@Api(value = "货币K线Controller",tags = {"货币K线接口"})
@RestController
@RequestMapping(value = "/api/web/KCurrency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class KCurrencyController {

    @ApiOperation(value = "货币K线",notes = "此接口进行货币K线查询")
    @PostMapping
    public ResultUtils KCurrency(KCurrencyVo kCurrencyVo){
        ApiHttp apiHttp=new ApiHttp(new APIConfiguration("https://www.okex.com"),new OkHttpClient());
        String result=apiHttp.get("/api/spot/v3/instruments/"+kCurrencyVo.getCurrencyName()+"-USDT/candles?granularity="+kCurrencyVo.getGranularity()+"&start="+kCurrencyVo.getStartTime()+"&end="+kCurrencyVo.getStopTime());
        return ResultUtils.success(result);
    }
}
