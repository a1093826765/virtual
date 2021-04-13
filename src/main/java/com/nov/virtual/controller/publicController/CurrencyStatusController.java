package com.nov.virtual.controller.publicController;

import com.alibaba.fastjson.JSONArray;
import com.nov.virtual.bean.resultJsonData.CurrencyStatusJsonData;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyStatusService;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.CurrencyStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 可操作货币状态接口
 * @author november
 */
@Api(value = "可操作货币状态Controller",tags = {"可操作货币状态接口"})
@RestController
@RequestMapping(value = "/api/public/currencyStatus",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyStatusController {

    @Autowired
    CurrencyStatusService currencyStatusService;

    @ApiOperation(value = "可操作货币状态查询",notes = "此接口查询系统可操作货币状态信息")
    @PostMapping("/query")
    public ResultUtils queryCurrencyStatus(){
        List<CurrencyStatus> currencyStatusList = currencyStatusService.getCurrencyStatusByExample(new CurrencyStatusExample());
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<currencyStatusList.size();i++){
            CurrencyStatus currencyStatus=currencyStatusList.get(i);
            CurrencyStatusJsonData currencyStatusJsonData=new CurrencyStatusJsonData(currencyStatus.getCurrencystatusid(),currencyStatus.getCurrencystatusname());
            jsonArray.add(currencyStatusJsonData.toQueryJson());
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加可操作货币状态",notes = "此接口添加系统可操作货币状态信息")
    @PostMapping("/insert")
    public ResultUtils insertCurrencyStatus(@Validated @RequestBody CurrencyStatusVo currencyStatusVo){
        CurrencyStatus currencyStatus =new CurrencyStatus();
        currencyStatus.setCurrencystatusname(currencyStatusVo.getCurrencyStatusName());
        if(currencyStatusService.save(currencyStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除可操作货币状态",notes = "此接口删除系统可操作货币状态信息")
    @PostMapping("/delete")
    public ResultUtils deleteCurrencyStatus(@Validated @RequestBody CurrencyStatusVo currencyStatusVo){
        CurrencyStatusKey currencyStatusKey=new CurrencyStatusKey();
        currencyStatusKey.setCurrencystatusid(currencyStatusVo.getCurrencyStatusId());
        if(currencyStatusService.deleteByKey(currencyStatusKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改可操作货币状态",notes = "此接口修改系统可操作货币状态信息")
    @PostMapping("/update")
    public ResultUtils updateCurrencyStatus(@Validated @RequestBody CurrencyStatusVo currencyStatusVo){
        CurrencyStatus currencyStatus =new CurrencyStatus();
        currencyStatus.setCurrencystatusid(currencyStatusVo.getCurrencyStatusId());
        currencyStatus.setCurrencystatusname(currencyStatusVo.getCurrencyStatusName());
        if(currencyStatusService.updateByKey(currencyStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }
}
