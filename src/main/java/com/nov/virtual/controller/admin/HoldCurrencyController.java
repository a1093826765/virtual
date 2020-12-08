package com.nov.virtual.controller.admin;

import com.github.pagehelper.PageInfo;
import com.nov.virtual.sql.model.CurrencyStatus;
import com.nov.virtual.sql.model.CurrencyStatusKey;
import com.nov.virtual.sql.model.HoldCurrency;
import com.nov.virtual.sql.model.HoldCurrencyKey;
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

/**
 * 持有货币接口
 * @author november
 */
@Api(value = "持有货币Controller",tags = {"持有货币接口"})
@RestController
@RequestMapping(value = "/api/admin/holdCurrency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class HoldCurrencyController {

    @Autowired
    HoldCurrencyService holdCurrencyService;

    @ApiOperation(value = "对应用户持有货币查询",notes = "此接口查询对应用户持有货币货币信息")
    @GetMapping("/query/{userId}")
    public ResultUtils queryHoldCurrency(@PathVariable long userId){
        return ResultUtils.success(holdCurrencyService.getDataJsonToUserID(userId));
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
