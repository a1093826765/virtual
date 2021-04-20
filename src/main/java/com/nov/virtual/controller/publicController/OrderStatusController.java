package com.nov.virtual.controller.publicController;

import com.alibaba.fastjson.JSONArray;
import com.nov.virtual.bean.resultJsonData.OrderStatusJsonData;
import com.nov.virtual.sql.model.OrderStatus;
import com.nov.virtual.sql.model.OrderStatusExample;
import com.nov.virtual.sql.model.OrderStatusKey;
import com.nov.virtual.sql.service.OrderStatusService;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.OrderStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单状态接口
 * @author november
 */
@Api(value = "公共订单状态Controller",tags = {"公共订单状态接口"})
@RestController
@RequestMapping(value = "/api/public/orderStatus",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class OrderStatusController {
    @Autowired
    OrderStatusService orderStatusService;

    @ApiOperation(value = "订单状态查询",notes = "此接口查询订单状态信息")
    @PostMapping("/query")
    public ResultUtils queryOrder(){
        List<OrderStatus> orderStatusList = orderStatusService.getOrderStatusByExample(new OrderStatusExample());
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<orderStatusList.size();i++){
            OrderStatus orderStatus=orderStatusList.get(i);
            OrderStatusJsonData orderStatusJsonData=new OrderStatusJsonData(orderStatus.getOrderstatusid(),orderStatus.getOrderstatusname());
            jsonArray.add(orderStatusJsonData.toQueryJson());
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加订单状态",notes = "此接口添加订单状态信息")
    @PostMapping("/insert")
    public ResultUtils insertOrder(@Validated @RequestBody OrderStatusVo orderStatusVo){
        OrderStatus orderStatus =new OrderStatus();
        orderStatus.setOrderstatusname(orderStatusVo.getOrderStatusName());
        if(orderStatusService.save(orderStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除订单状态",notes = "此接口删除订单状态信息")
    @PostMapping("/delete")
    public ResultUtils deleteOrder(@Validated @RequestBody OrderStatusVo orderStatusVo){
        OrderStatusKey orderStatusKey=new OrderStatusKey();
        orderStatusKey.setOrderstatusid(orderStatusVo.getOrderStatusId());
        if(orderStatusService.deleteByKey(orderStatusKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改订单状态",notes = "此接口修改订单状态信息")
    @PostMapping("/update")
    public ResultUtils updateOrder(@Validated @RequestBody OrderStatusVo orderStatusVo){
        OrderStatus orderStatus =new OrderStatus();
        orderStatus.setOrderstatusid(orderStatusVo.getOrderStatusId());
        orderStatus.setOrderstatusname(orderStatusVo.getOrderStatusName());
        if(orderStatusService.updateByKey(orderStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }
}
