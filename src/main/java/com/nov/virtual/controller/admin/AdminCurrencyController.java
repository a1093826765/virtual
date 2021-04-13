package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.bean.resultJsonData.CurrencyJsonData;
import com.nov.virtual.bean.resultJsonData.PageJsonData;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.sql.service.CurrencyStatusService;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.admin.currency.DeleteCurrencyVo;
import com.nov.virtual.vo.admin.currency.InsertCurrencyVo;
import com.nov.virtual.vo.admin.currency.UpdateCurrencyVo;
import com.nov.virtual.vo.config.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员可操作货币接口
 * @author november
 */
@Api(value = "管理员可操作货币Controller",tags = {"管理员可操作货币接口"})
@RestController
@RequestMapping(value = "/api/admin/currency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class AdminCurrencyController {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    CurrencyStatusService currencyStatusService;

    @ApiOperation(value = "分页货币查询",notes = "此接口分页查询系统可操作的货币信息")
    @PostMapping("/query")
    public ResultUtils queryCurrency(@Validated @RequestBody PageVo pageVo){
        System.out.println(212);
        PageInfo<Currency> pageInfo = currencyService.getMenus(pageVo.getPage(), pageVo.getLimit(), new CurrencyExample());
        List<Currency> currencyList=pageInfo.getList();
        JSONArray jsonArray=new JSONArray();
        CurrencyStatusKey currencyStatusKey=new CurrencyStatusKey();
        for(int i=0;i<currencyList.size();i++){
            Currency currency=currencyList.get(i);
            currencyStatusKey.setCurrencystatusid(currency.getCurrencyCurrencystatusid());
            CurrencyJsonData currencyJsonData=new CurrencyJsonData(currency.getCurrencyid(),currency.getCurrencyname(),currencyStatusService.getCurrencyStatusByKey(currencyStatusKey).getCurrencystatusname(),currency.getCurrencyChinename(),currency.getCurrencyImg());
            jsonArray.add(currencyJsonData.toQueryJson());
        }
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(),pageInfo.getPages(),jsonArray,pageInfo.getTotal()).toJson());
    }

    @ApiOperation(value = "添加货币",notes = "此接口添加系统可操作的货币信息")
    @PostMapping("/insert")
    public ResultUtils insertCurrency(@Validated @RequestBody InsertCurrencyVo insertCurrencyVo){
        Currency currency =new Currency();
        currency.setCurrencyname(insertCurrencyVo.getCurrencyName());
        currency.setCurrencyCurrencystatusid(insertCurrencyVo.getCurrencyStatusId());
        currency.setCurrencyChinename(insertCurrencyVo.getCurrencyChineName());
        currency.setCurrencyImg("/img/currency/"+ insertCurrencyVo.getCurrencyName()+".jpg");
        if(currencyService.save(currency)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除货币",notes = "此接口删除系统可操作的货币信息")
    @PostMapping("/delete")
    public ResultUtils deleteCurrency(@Validated @RequestBody DeleteCurrencyVo deleteCurrencyVo){
        CurrencyKey currencyKey=new CurrencyKey();
        currencyKey.setCurrencyid(deleteCurrencyVo.getCurrencyId());
        if(currencyService.deleteByKey(currencyKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改货币",notes = "此接口修改系统可操作的货币信息")
    @PostMapping("/update")
    public ResultUtils updateCurrency(@Validated @RequestBody UpdateCurrencyVo updateCurrencyVo){
        Currency currency =new Currency();
        currency.setCurrencyid(updateCurrencyVo.getCurrencyId());
        currency.setCurrencyname(updateCurrencyVo.getCurrencyName());
        currency.setCurrencyCurrencystatusid(updateCurrencyVo.getCurrencyStatusId());
        currency.setCurrencyChinename(updateCurrencyVo.getCurrencyChineName());
        currency.setCurrencyImg("/img/currency/"+ updateCurrencyVo.getCurrencyName()+".jpg");
        if(currencyService.updateByKey(currency)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

}
