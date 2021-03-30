package com.nov.virtual.controller.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.bean.resultJsonData.HoldCurrencyJsonData;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.client.ApiHttp;
import com.nov.virtual.shop.okEx.okcoin.commons.okex.open.api.config.APIConfiguration;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.HoldCurrencyService;
import com.nov.virtual.utils.UserContextUtil;
import com.nov.virtual.utils.pojo.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 当前用户持有货币接口
 * @author november
 */
@Api(value = "当前用户持有货币Controller",tags = {"当前用户持有货币接口"})
@RestController
@RequestMapping(value = "/api/web/holdCurrency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class HoldCurrencyController {

    @Autowired
    HoldCurrencyService holdCurrencyService;

    @Autowired
    CurrencyService currencyService;

    @ApiOperation(value = "当前用户持有货币查询",notes = "此接口查询当前用户持有货币货币信息")
    @GetMapping("/query")
    public ResultUtils queryHoldCurrency(){
        HoldCurrencyExample holdCurrencyExample=new HoldCurrencyExample();
        HoldCurrencyExample.Criteria criteria=holdCurrencyExample.createCriteria();
        criteria.andHoldcurrencyUseridEqualTo(UserContextUtil.getUserVirtualBean().getUserVirtual().getUserid());
        List<HoldCurrency> holdCurrencyList = holdCurrencyService.getHoldCurrencyByExample(holdCurrencyExample);
        CurrencyKey currencyKey=new CurrencyKey();
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<holdCurrencyList.size();i++){
            HoldCurrency holdCurrency=holdCurrencyList.get(i);
            currencyKey.setCurrencyid(holdCurrency.getHoldcurrencyCurrencyid());
            String currencyName= currencyService.getCurrencyByKey(currencyKey).getCurrencyname();
            HoldCurrencyJsonData holdCurrencyJsonData=new HoldCurrencyJsonData(holdCurrency.getHoldcurrencyid(),getNewPrice(currencyName),holdCurrency.getHoldcurrencynum(),currencyName);
            jsonArray.add(holdCurrencyJsonData.toQueryJson());
        }
        return ResultUtils.success(jsonArray);
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

//    @ApiOperation(value = "添加持有货币",notes = "此接口添加持有货币")
//    @PostMapping("/insert")
//    public ResultUtils insertHoldCurrency(@Validated @RequestBody HoldCurrencyVo holdCurrencyVo){
//        if(holdCurrencyService.insert(holdCurrencyVo)==1){
//            return ResultUtils.success();
//        }
//        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
//    }

//    @ApiOperation(value = "删除持有货币",notes = "此接口持有货币信息")
//    @PostMapping("/delete")
//    public ResultUtils deleteHoldCurrency(@Validated @RequestBody HoldCurrencyVo holdCurrencyVo){
//        HoldCurrencyKey holdCurrencyKey=new HoldCurrencyKey();
//        holdCurrencyKey.setHoldcurrencyid(holdCurrencyVo.getHoldCurrencyId());
//        if(holdCurrencyService.deleteByKey(holdCurrencyKey)==1){
//            return ResultUtils.success();
//        }
//        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
//    }

//    @ApiOperation(value = "修改持有货币",notes = "此接口修改持有货币信息")
//    @PostMapping("/update")
//    public ResultUtils updateHoldCurrency(@Validated @RequestBody HoldCurrencyVo holdCurrencyVo){
//        HoldCurrency holdCurrency=new HoldCurrency();
//        holdCurrency.setHoldcurrencyid(holdCurrencyVo.getHoldCurrencyId());
//        holdCurrency.setHoldcurrencynum(holdCurrencyVo.getHoldCurrencyNum());
//        holdCurrency.setHoldcurrencymoney(holdCurrencyVo.getHoldCurrencyMoney());
//        holdCurrency.setHoldcurrencyCurrencyid(holdCurrencyVo.getCurrencyId());
//        if(holdCurrencyService.updateByKey(holdCurrency)==1){
//            return ResultUtils.success();
//        }
//        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
//    }
}
