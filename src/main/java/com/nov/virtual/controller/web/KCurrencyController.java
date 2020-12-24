package com.nov.virtual.controller.web;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.utils.pojo.ResultUtils;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public ResultUtils KCurrency(@Validated @RequestBody KCurrencyVo kCurrencyVo) throws ParseException {
        System.out.println(kCurrencyVo.getGranularity()+"   "+kCurrencyVo.getCurrencyName() );
        ApiHttp apiHttp=new ApiHttp(new APIConfiguration("https://www.okex.com"),new OkHttpClient());
//        String result=apiHttp.get("/api/spot/v3/instruments/"+kCurrencyVo.getCurrencyName()+"-USDT/candles?granularity="+kCurrencyVo.getGranularity()+"&start="+kCurrencyVo.getStartTime()+"&end="+kCurrencyVo.getStopTime());
        String result=apiHttp.get("/api/spot/v3/instruments/"+kCurrencyVo.getCurrencyName()+"-USDT/candles?granularity="+kCurrencyVo.getGranularity());
        System.out.println(result);
        String[] split = result.split(",");
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<split.length;i++) {
            split[i]=split[i].replaceAll("\\[","").replaceAll("]","").replaceAll("\"","");
            if((i+1)%6==0){
                JSONObject jsonObject=new JSONObject();
                Date date = DateUtil.parse(split[i-5], "yyyy-MM-dd");
                jsonObject.put("time",date.toString().substring(0,date.toString().indexOf(" ")));
                jsonObject.put("open",split[i-4]);
                jsonObject.put("high",split[i-3]);
                jsonObject.put("low",split[i-2]);
                jsonObject.put("close",split[i-1]);
                jsonObject.put("volume",split[i]);
                jsonArray.add(jsonObject);
            }
        }
        return ResultUtils.success(jsonArray);
    }
}
