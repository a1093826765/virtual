package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.sql.mapper.OrderMapper;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.CurrencyStatusService;
import com.nov.virtual.sql.service.OrderService;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.AdminPageVo;
import com.nov.virtual.vo.CurrencyStatusVo;
import com.nov.virtual.vo.OrderVo;
import com.nov.virtual.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 订单接口
 * @author november
 */
@Api(value = "订单Controller",tags = {"订单接口"})
@RestController
@RequestMapping(value = "/api/admin/order",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation(value = "订单分页查询",notes = "此接口分页查询订单")
    @PostMapping("/query")
    public ResultUtils queryCurrency(@Validated @RequestBody AdminPageVo adminPageVo){
        return ResultUtils.success(orderService.getMenusToUserId(adminPageVo.getPage(),adminPageVo.getLimit(),adminPageVo.getUserId()));
    }

    @ApiOperation(value = "添加订单信息",notes = "此接口添加订单信息")
    @PostMapping("/insert")
    public ResultUtils insertCurrency(@Validated @RequestBody OrderVo orderVo){
        Order order=new Order();
        order.setOrderbuytime(new Date());
        order.setOrderCurrencyid(orderVo.getOrderCurrencyId());
        order.setOrderCurrencynum(orderVo.getOrderNum());
        order.setOrdernumber(orderVo.getOrderNum());
        order.setOrderprice(orderVo.getOrderPrice());
        order.setOrderStatusid(orderVo.getOrderStatusId());
        order.setOrderTypeid(orderVo.getOrderTypeId());
        order.setOrderUserid(orderVo.getOrderUserId());
        if(orderService.save(order)==1){
            return ResultUtils.fail(ResultCode.SUCCESS);
        }
            return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除订单",notes = "此接口删除订单信息")
    @PostMapping("/delete")
    public ResultUtils deleteCurrency(@Validated @RequestBody OrderVo orderVo){
        OrderKey orderKey=new OrderKey();
        orderKey.setOrderid(orderVo.getOrderId());
        if(orderService.deleteByKey(orderKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改订单",notes = "此接口修改订单信息")
    @PostMapping("/update")
    public ResultUtils updateCurrency(@Validated @RequestBody OrderVo orderVo){
        Order order=new Order();
        order.setOrderid(orderVo.getOrderId());
        order.setOrderCurrencyid(orderVo.getOrderCurrencyId());
        order.setOrderCurrencynum(orderVo.getOrderNum());
        order.setOrdernumber(orderVo.getOrderNum());
        order.setOrderprice(orderVo.getOrderPrice());
        order.setOrderStatusid(orderVo.getOrderStatusId());
        order.setOrderTypeid(orderVo.getOrderTypeId());
        if(orderService.updateByKey(order)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }
}
