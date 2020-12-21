package com.nov.virtual.controller.web;

import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.sql.model.Currency;
import com.nov.virtual.sql.model.CurrencyKey;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualKey;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.UserVirtualService;
import com.nov.virtual.utils.UserContextUtil;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.BuyVo;
import com.nov.virtual.vo.LoginVo;
import com.nov.virtual.vo.SellVo;
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

/**
 * 用户交易api
 * @author november
 */
@Api(value = "用户交易Controller",tags = {"用户交易接口"})
@RestController
@RequestMapping(value = "/api/web/transaction",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    @Autowired
    private UserVirtualService userVirtualService;

    /**
     * 用户买币
     * @param buyVo
     * @return
     */
    @ApiOperation(value = "用户买币",notes = "此接口进行用户买币操作")
    @PostMapping("/buy")
    public ResultUtils buy(@Validated @RequestBody BuyVo buyVo){
        ApiHttp apiHttp=new ApiHttp(new APIConfiguration("https://www.okex.com"),new OkHttpClient());
        String result=apiHttp.get("/api/index/v3/"+buyVo.getCurrencyName()+"-USD/constituents");
        JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
        jsonObject= (JSONObject)JSONObject.parse(jsonObject.getString("data"));
        String money = jsonObject.getString("last");
        UserVirtualKey userVirtualKey=new UserVirtualKey();
        userVirtualKey.setUserid(UserContextUtil.getUserVirtualBean().getUserId());
        UserVirtual user = userVirtualService.getUserByKey(userVirtualKey);
        // 余额=钱包-购买价格
        double lastMoney=Double.parseDouble(user.getMoney())-(Double.parseDouble(money)*Double.parseDouble(buyVo.getCurrencyNum()));
        if(lastMoney>=0){
            user.setMoney(String.valueOf(lastMoney));
            userVirtualService.updateByKey(user);
            return ResultUtils.success();
        }else{
            return ResultUtils.fail(ResultCode.USER_NOT_MONEY);
        }
    }

    /**
     * 用户卖币
     * @param sellVo
     * @return
     */
    @ApiOperation(value = "用户卖币",notes = "此接口进行用户卖币操作")
    @PostMapping("/sell")
    public ResultUtils sell(@Validated @RequestBody SellVo sellVo){
        ApiHttp apiHttp=new ApiHttp(new APIConfiguration("https://www.okex.com"),new OkHttpClient());
        String result=apiHttp.get("/api/index/v3/"+sellVo.getCurrencyName()+"-USD/constituents");
        JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
        jsonObject= (JSONObject)JSONObject.parse(jsonObject.getString("data"));
        String money = jsonObject.getString("last");
        UserVirtualKey userVirtualKey=new UserVirtualKey();
        userVirtualKey.setUserid(UserContextUtil.getUserVirtualBean().getUserId());
        UserVirtual user = userVirtualService.getUserByKey(userVirtualKey);
        double lastMoney=Double.parseDouble(user.getMoney())+(Double.parseDouble(money)*Double.parseDouble(sellVo.getCurrencyNum()));
        user.setMoney(String.valueOf(lastMoney));
        userVirtualService.updateByKey(user);
        return ResultUtils.success();
    }
}
