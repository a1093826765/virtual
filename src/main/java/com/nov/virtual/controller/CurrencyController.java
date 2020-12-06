package com.nov.virtual.controller;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.Currency;
import com.nov.virtual.sql.model.CurrencyExample;
import com.nov.virtual.sql.model.CurrencyKey;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.CurrencyVo;
import com.nov.virtual.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 可操作货币接口
 * @author november
 */
@Api(value = "可操作货币Controller",tags = {"可操作货币接口"})
@RestController
@RequestMapping(value = "/api/currency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @ApiOperation(value = "分页货币查询",notes = "此接口分页查询系统可操作的货币信息")
    @PostMapping("/query")
    public ResultUtils queryCurrency(@Validated @RequestBody PageVo pageVo){
        PageInfo<Currency> pageInfo = currencyService.getMenus(pageVo.getPage(), pageVo.getLimit(), new CurrencyExample());
        return ResultUtils.success(pageInfo);
    }

    @ApiOperation(value = "添加货币",notes = "此接口添加系统可操作的货币信息")
    @PostMapping("/insert")
    public ResultUtils insertCurrency(@Validated @RequestBody CurrencyVo currencyVo){
        Currency currency =new Currency();
        currency.setCurrencyname(currencyVo.getCurrencyName());
        if(currencyService.save(currency)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除货币",notes = "此接口删除系统可操作的货币信息")
    @PostMapping("/delete")
    public ResultUtils deleteCurrency(@Validated @RequestBody CurrencyVo currencyVo){
        CurrencyKey currencyKey=new CurrencyKey();
        currencyKey.setCurrencyid(currencyVo.getCurrencyId());
        if(currencyService.deleteByKey(currencyKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改货币",notes = "此接口修改系统可操作的货币信息")
    @PostMapping("/update")
    public ResultUtils updateCurrency(@Validated @RequestBody CurrencyVo currencyVo){
        Currency currency =new Currency();
        currency.setCurrencyid(currencyVo.getCurrencyId());
        currency.setCurrencyname(currencyVo.getCurrencyName());
        currency.setCurrencyCurrencystatusid(currencyVo.getCurrencyStatusId());
        if(currencyService.updateByKey(currency)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

}
