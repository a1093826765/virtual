package com.nov.virtual.controller.web;

import com.nov.virtual.service.OkExService;
import com.nov.virtual.bean.resultJsonData.PersonJsonData;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.HoldCurrencyService;
import com.nov.virtual.utils.UserContextUtil;
import com.nov.virtual.utils.pojo.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
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

    @Autowired
    OkExService okExService;

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
        //货币总数
        double currencyNumSize=0;
        //总购买价格
        double moneySize=0;
        //当前最新总价
        double newMoneySize=0;
        //货币购买价格
        double currencyMoney=0;
        CurrencyKey currencyKey=new CurrencyKey();
        for(HoldCurrency holdCurrency:holdCurrencyList){
            currencyMoney=Double.parseDouble(holdCurrency.getHoldcurrencymoney());
            moneySize+=currencyMoney;
            currencyNumSize=currencyNumSize+Double.parseDouble(holdCurrency.getHoldcurrencynum());
            currencyKey.setCurrencyid(holdCurrency.getHoldcurrencyCurrencyid());
            String newPrice = getNewPrice(currencyService.getCurrencyByKey(currencyKey).getCurrencyname());
            newMoneySize+=(Double.parseDouble(newPrice)*Double.parseDouble(holdCurrency.getHoldcurrencynum()));
        }
        //盈利金额
        double profitMoney=newMoneySize-moneySize;
        DecimalFormat dcmFmt = new DecimalFormat("0.0000");
        String profit = dcmFmt.format(((1-(moneySize/newMoneySize))*100));
        System.out.println(profit);
        PersonJsonData personJsonData=new PersonJsonData(String.valueOf(Double.parseDouble(userVirtual.getMoney())+profitMoney),profit,profitMoney,currencyNumSize,userVirtual.getUsername());
        return ResultUtils.success(personJsonData.toJson());
    }

    /**
     * 获取最新价格
     *
     * @return
     */
    private String getNewPrice(String currencyName) {
        return okExService.getNewMoney(currencyName);
    }
}
