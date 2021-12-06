package com.nov.virtual.controller.web;

import com.nov.virtual.service.StrategyService;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.BuyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: november
 * @CreateTime: 2021/3/31 9:46 上午
 * @UpdateTIme:
 */
@Api(value = "策略Controller", tags = {"策略接口"})
@RestController
@RequestMapping(value = "/api/web/strategy", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class StrategyController {

    @Autowired
    StrategyService strategyService;

    @ApiOperation(value = "策略买币", notes = "策略买币")
    @PostMapping("/strategyBuy")
    @Transactional
    public ResultUtils strategyBuy() {
        String s = strategyService.strategyBuy();
        return ResultUtils.success(s);
    }

    @ApiOperation(value = "策略卖币", notes = "策略卖币")
    @PostMapping("/strategySell")
    @Transactional
    public ResultUtils strategySell() {
        String s = strategyService.strategySell();
        return ResultUtils.success(s);
    }

}
