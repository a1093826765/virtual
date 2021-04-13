package com.nov.virtual.controller.web;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.bean.resultJsonData.CurrencyJsonData;
import com.nov.virtual.bean.resultJsonData.PageJsonData;
import com.nov.virtual.sql.model.Currency;
import com.nov.virtual.sql.model.CurrencyExample;
import com.nov.virtual.sql.service.CurrencyService;
import com.nov.virtual.utils.pojo.ResultUtils;
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
 * 可操作货币接口
 * @author november
 */
@Api(value = "可操作货币Controller",tags = {"可操作货币接口"})
@RestController
@RequestMapping(value = "/api/web/currency",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @ApiOperation(value = "分页货币查询",notes = "此接口分页查询系统可操作的货币信息")
    @PostMapping("/query")
    public ResultUtils queryCurrency(@Validated @RequestBody PageVo pageVo){
        CurrencyExample currencyExample = new CurrencyExample();
        CurrencyExample.Criteria criteria = currencyExample.createCriteria();
        criteria.andCurrencyCurrencystatusidNotEqualTo(2);
        PageInfo<Currency> pageInfo = currencyService.getMenus(pageVo.getPage(), pageVo.getLimit(),currencyExample);
        List<Currency> currencyList=pageInfo.getList();
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<currencyList.size();i++){
            Currency currency=currencyList.get(i);
            CurrencyJsonData currencyJsonData=new CurrencyJsonData(currency.getCurrencyid(),currency.getCurrencyname(),"启用",currency.getCurrencyChinename(),currency.getCurrencyImg());
            jsonArray.add(currencyJsonData.toQueryJson());
        }
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(),pageInfo.getPages(),jsonArray,pageInfo.getSize()).toJson());
    }
}
