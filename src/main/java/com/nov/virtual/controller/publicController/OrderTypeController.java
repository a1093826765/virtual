package com.nov.virtual.controller.publicController;

import com.alibaba.fastjson.JSONArray;
import com.nov.virtual.bean.resultJsonData.OrderTypeJsonData;
import com.nov.virtual.sql.model.OrderType;
import com.nov.virtual.sql.model.OrderTypeExample;
import com.nov.virtual.sql.model.OrderTypeKey;
import com.nov.virtual.sql.service.OrderTypeService;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.OrderTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单类型接口
 * @author november
 */
@Api(value = "订单类型Controller",tags = {"订单类型接口"})
@RestController
@RequestMapping(value = "/api/public/orderType",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class OrderTypeController {
    @Autowired
    OrderTypeService orderTypeService;

    @ApiOperation(value = "订单类型查询",notes = "此接口查询订单类型信息")
    @PostMapping("/query")
    public ResultUtils queryOrder(){
        List<OrderType> orderTypeList = orderTypeService.getOrderTypeByExample(new OrderTypeExample());
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<orderTypeList.size();i++){
            OrderType orderType=orderTypeList.get(i);
            OrderTypeJsonData orderTypeJsonData=new OrderTypeJsonData(orderType.getOrdertypeid(),orderType.getOrdertypename());
            jsonArray.add(orderTypeJsonData.toQueryJson());
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加订单类型",notes = "此接口添加订单类型信息")
    @PostMapping("/insert")
    public ResultUtils insertOrder(@Validated @RequestBody OrderTypeVo orderTypeVo){
        OrderType orderType =new OrderType();
        orderType.setOrdertypename(orderTypeVo.getOrderTypeName());
        if(orderTypeService.save(orderType)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除订单类型",notes = "此接口删除订单类型信息")
    @PostMapping("/delete")
    public ResultUtils deleteOrder(@Validated @RequestBody OrderTypeVo orderTypeVo){
        OrderTypeKey orderTypeKey=new OrderTypeKey();
        orderTypeKey.setOrdertypeid(orderTypeVo.getOrderTypeId());
        if(orderTypeService.deleteByKey(orderTypeKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改订单类型",notes = "此接口修改订单类型信息")
    @PostMapping("/update")
    public ResultUtils updateOrder(@Validated @RequestBody OrderTypeVo orderTypeVo){
        OrderType orderType =new OrderType();
        orderType.setOrdertypeid(orderTypeVo.getOrderTypeId());
        orderType.setOrdertypename(orderTypeVo.getOrderTypeName());
        if(orderTypeService.updateByKey(orderType)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }
}
