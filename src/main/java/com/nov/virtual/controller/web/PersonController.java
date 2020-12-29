package com.nov.virtual.controller.web;

import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.bean.ResultJsonData.PersonJsonData;
import com.nov.virtual.config.Address;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.HoldCurrencyExample;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.HoldCurrencyService;
import com.nov.virtual.utils.UserContextUtil;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.utils.pojo.TokenUtils;
import com.nov.virtual.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: november
 * Date: 2020/12/28 10:33 上午
 */
@Api(value = "个人信息Controller",tags = {"用户个人信息接口"})
@RestController
@RequestMapping(value = "/api/web/person",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    HoldCurrencyService holdCurrencyService;

    @Autowired
    CurrencyService currencyService;

    /**
     * 个人信息
     * @return
     */
    @ApiOperation(value = "个人信息",notes = "此接口进行查询个人信息")
    @PostMapping
    public ResultUtils person(){
        UserVirtual userVirtual= UserContextUtil.getUserVirtualBean().getUserVirtual();

        //持有货币List
        HoldCurrencyExample holdCurrencyExample=new HoldCurrencyExample();
        HoldCurrencyExample.Criteria holdCurrencyExampleCriteria = holdCurrencyExample.createCriteria();
        holdCurrencyExampleCriteria.andHoldcurrencyUseridEqualTo(userVirtual.getUserid());
        List<HoldCurrency> holdCurrencyList = holdCurrencyService.getHoldCurrencyByExample(holdCurrencyExample);
        double currencyNumSize=0;
        for(HoldCurrency holdCurrency:holdCurrencyList){
            currencyNumSize=currencyNumSize+Double.parseDouble(holdCurrency.getHoldcurrencynum());

        }
//        PersonJsonData personJsonData=new PersonJsonData(userVirtual.getMoney(),profit,profitMoney,currencyNumSize);
//        return ResultUtils.success(personJsonData.toJson());
        return null;
    }

    /**
     * 获取最新价格
     *
     * @return
     */
    private String getNewPrice(String currencyName) {
        ApiHttp apiHttp = new ApiHttp(new APIConfiguration("https://www.okex.com"), new OkHttpClient());
        String result = apiHttp.get("/api/index/v3/" + currencyName + "-USD/constituents");
        JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
        jsonObject = (JSONObject) JSONObject.parse(jsonObject.getString("data"));
        return jsonObject.getString("last");
    }
}
