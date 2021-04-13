package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.nov.virtual.bean.resultJsonData.HoldCurrencyJsonData;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.HoldCurrencyService;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.admin.holdCurrency.DeleteHoldCurrencyVo;
import com.nov.virtual.vo.admin.holdCurrency.InsertHoldCurrencyVo;
import com.nov.virtual.vo.admin.holdCurrency.QueryHoldCurrencyVo;
import com.nov.virtual.vo.admin.holdCurrency.UpdateHoldCurrencyVo;
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
@Api(value = "管理员持有货币Controller",tags = {"管理员持有货币管理员接口"})
@RestController
@RequestMapping(value = "/api/admin/holdCurrency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class AdminHoldCurrencyController {

    @Autowired
    HoldCurrencyService holdCurrencyService;

    @Autowired
    CurrencyService currencyService;

    @ApiOperation(value = "对应用户持有货币查询",notes = "此接口查询对应用户持有货币货币信息")
//    @GetMapping("/query/{userId}")
//    public ResultUtils queryHoldCurrency(@PathVariable long userId){
    @PostMapping("/query")
    public ResultUtils queryHoldCurrency(@Validated @RequestBody QueryHoldCurrencyVo queryHoldCurrencyVo){
        HoldCurrencyExample holdCurrencyExample=new HoldCurrencyExample();
        HoldCurrencyExample.Criteria criteria=holdCurrencyExample.createCriteria();
        criteria.andHoldcurrencyUseridEqualTo(queryHoldCurrencyVo.getUserId());
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
    public ResultUtils insertHoldCurrency(@Validated @RequestBody InsertHoldCurrencyVo insertHoldCurrencyVo){
        if(holdCurrencyService.insert(insertHoldCurrencyVo)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除持有货币",notes = "此接口持有货币信息")
    @PostMapping("/delete")
    public ResultUtils deleteHoldCurrency(@Validated @RequestBody DeleteHoldCurrencyVo deleteHoldCurrencyVo){
        HoldCurrencyKey holdCurrencyKey=new HoldCurrencyKey();
        holdCurrencyKey.setHoldcurrencyid(deleteHoldCurrencyVo.getHoldCurrencyId());
        if(holdCurrencyService.deleteByKey(holdCurrencyKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改持有货币",notes = "此接口修改持有货币信息")
    @PostMapping("/update")
    public ResultUtils updateHoldCurrency(@Validated @RequestBody UpdateHoldCurrencyVo updateHoldCurrencyVo){
        HoldCurrencyKey holdCurrencyKey=new HoldCurrencyKey();
        holdCurrencyKey.setHoldcurrencyid(updateHoldCurrencyVo.getHoldCurrencyId());
        HoldCurrency holdCurrency=holdCurrencyService.getHoldCurrencyByKey(holdCurrencyKey);
        holdCurrency.setHoldcurrencynum(updateHoldCurrencyVo.getHoldCurrencyNum());
        holdCurrency.setHoldcurrencymoney(updateHoldCurrencyVo.getHoldCurrencyMoney());
        holdCurrency.setHoldcurrencyCurrencyid(updateHoldCurrencyVo.getCurrencyId());
        if(holdCurrencyService.updateByKey(holdCurrency)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }
}
