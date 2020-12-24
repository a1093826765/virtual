package com.nov.virtual.controller.web;

import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.CurrencyNewMoencyVo;
import com.nov.virtual.vo.KCurrencyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * Created by IntelliJ IDEA.
 * 获取最新价接口
 * @Author: november
 * Date: 2020/12/23 4:03 下午
 */
@Api(value = "货币最新价Controller",tags = {"货币最新价接口"})
@RestController
@RequestMapping(value = "/api/web/NewMoney",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyNewMoneyController {
    @ApiOperation(value = "货币最新价",notes = "此接口进行货币最新价查询")
    @PostMapping
    public ResultUtils KCurrency(@Validated @RequestBody CurrencyNewMoencyVo currencyNewMoencyVo) throws ParseException {
        ApiHttp apiHttp=new ApiHttp(new APIConfiguration("https://www.okex.com"),new OkHttpClient());
        String result=apiHttp.get("api/spot/v3/instruments/"+currencyNewMoencyVo.getCurrencyName()+"-USDT/ticker");
        return ResultUtils.success(result);
    }
}
