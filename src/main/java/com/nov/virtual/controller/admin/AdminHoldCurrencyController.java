package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.bean.ResultJsonData.HoldCurrencyJsonData;
import com.nov.virtual.sql.mapper.CurrencyMapper;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.HoldCurrencyService;
import com.nov.virtual.utils.UserContextUtil;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.CurrencyStatusVo;
import com.nov.virtual.vo.HoldCurrencyVo;
import com.nov.virtual.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 持有货币管理员接口
 * @author november
 */
@Api(value = "持有货币Controller",tags = {"持有货币管理员接口"})
@RestController
@RequestMapping(value = "/api/admin/holdCurrency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class AdminHoldCurrencyController {

    @Autowired
    HoldCurrencyService holdCurrencyService;

    @Autowired
    CurrencyService currencyService;

    @ApiOperation(value = "对应用户持有货币查询",notes = "此接口查询对应用户持有货币货币信息")
    @GetMapping("/query/{userId}")
    public ResultUtils queryHoldCurrency(@PathVariable long userId){
//    @GetMapping("/query")
//    public ResultUtils queryHoldCurrency(@RequestParam long userId){
        HoldCurrencyExample holdCurrencyExample=new HoldCurrencyExample();
        HoldCurrencyExample.Criteria criteria=holdCurrencyExample.createCriteria();
        criteria.andHoldcurrencyUseridEqualTo(userId);
        List<HoldCurrency> holdCurrencyList = holdCurrencyService.getHoldCurrencyByExample(holdCurrencyExample);
        CurrencyKey currencyKey=new CurrencyKey();
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<holdCurrencyList.size();i++){
            HoldCurrency holdCurrency=holdCurrencyList.get(i);
            currencyKey.setCurrencyid(holdCurrency.getHoldcurrencyCurrencyid());
            HoldCurrencyJsonData holdCurrencyJsonData=new HoldCurrencyJsonData(holdCurrency.getHoldcurrencyid(),holdCurrency.getHoldcurrencymoney(),holdCurrency.getHoldcurrencynum(),currencyService.getCurrencyByKey(currencyKey).getCurrencyname());
            jsonArray.add(holdCurrencyJsonData.toQueryJson());
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加持有货币",notes = "此接口添加持有货币")
    @PostMapping("/insert")
    public ResultUtils insertHoldCurrency(@Validated @RequestBody HoldCurrencyVo holdCurrencyVo){
        if(holdCurrencyService.insert(holdCurrencyVo)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除持有货币",notes = "此接口持有货币信息")
    @PostMapping("/delete")
    public ResultUtils deleteHoldCurrency(@Validated @RequestBody HoldCurrencyVo holdCurrencyVo){
        HoldCurrencyKey holdCurrencyKey=new HoldCurrencyKey();
        holdCurrencyKey.setHoldcurrencyid(holdCurrencyVo.getHoldCurrencyId());
        if(holdCurrencyService.deleteByKey(holdCurrencyKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改持有货币",notes = "此接口修改持有货币信息")
    @PostMapping("/update")
    public ResultUtils updateHoldCurrency(@Validated @RequestBody HoldCurrencyVo holdCurrencyVo){
        HoldCurrency holdCurrency=new HoldCurrency();
        holdCurrency.setHoldcurrencyid(holdCurrencyVo.getHoldCurrencyId());
        holdCurrency.setHoldcurrencynum(holdCurrencyVo.getHoldCurrencyNum());
        holdCurrency.setHoldcurrencymoney(holdCurrencyVo.getHoldCurrencyMoney());
        holdCurrency.setHoldcurrencyCurrencyid(holdCurrencyVo.getCurrencyId());
        if(holdCurrencyService.updateByKey(holdCurrency)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }
}
