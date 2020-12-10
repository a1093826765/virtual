package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.bean.ResultJsonData.OrderJsonData;
import com.nov.virtual.bean.ResultJsonData.PageJsonData;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.*;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.*;
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

    @Autowired
    UserVirtualService userVirtualService;

    @Autowired
    OrderTypeService orderTypeService;

    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    CurrencyService currencyService;


    @ApiOperation(value = "订单分页搜索",notes = "此接口分页搜索订单")
    @PostMapping("/search")
    public ResultUtils searchOrder(@Validated @RequestBody SearchVo searchVo){
        // 模糊查询账号account
        UserVirtualExample userVirtualExample=new UserVirtualExample();
        UserVirtualExample.Criteria userCriteria = userVirtualExample.createCriteria();
        userCriteria.andAccountLike("%"+searchVo.getTitle()+"%");
        List<UserVirtual> userVirtualList = userVirtualService.getUserByExample(userVirtualExample);
        // 查询对应的用户订单
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria orderCriteria;
        for(int i=0;i<userVirtualList.size();i++){
            orderCriteria=orderExample.createCriteria();
            UserVirtual userVirtual=userVirtualList.get(i);
            orderCriteria.andOrderUseridEqualTo(userVirtual.getUserid());
            orderExample.or(orderCriteria);
        }
        // 模糊查询订单号
        orderCriteria=orderExample.createCriteria();
        orderCriteria.andOrdernumberLike("%"+searchVo.getTitle()+"%");
        orderExample.or(orderCriteria);
        PageInfo pageInfo = orderService.getMenus(searchVo.getPage(), searchVo.getLimit(), orderExample);

        List<Order> orderList=pageInfo.getList();
        JSONArray jsonArray=new JSONArray();
        UserVirtualKey userVirtualKey=new UserVirtualKey();
        OrderTypeKey orderTypeKey=new OrderTypeKey();
        OrderStatusKey orderStatusKey=new OrderStatusKey();
        CurrencyKey currencyKey=new CurrencyKey();
        for(int i=0;i<orderList.size();i++){
            Order order=orderList.get(i);
            userVirtualKey.setUserid(order.getOrderUserid());
            currencyKey.setCurrencyid(order.getOrderCurrencyid());
            orderTypeKey.setOrdertypeid(order.getOrderStatusid());
            orderStatusKey.setOrderstatusid(order.getOrderStatusid());
            OrderJsonData orderJsonData=new OrderJsonData(order.getOrderid(),order.getOrderbuytime(),order.getOrderselltime(),currencyService.getCurrencyByKey(currencyKey).getCurrencyname(),order.getOrderCurrencynum(),order.getOrderprice(),orderTypeService.getOrderTypeByKey(orderTypeKey).getOrdertypename(),order.getOrdernumber(),orderStatusService.getOrderStatusByKey(orderStatusKey).getOrderstatusname(),userVirtualService.getUserByKey(userVirtualKey).getAccount());
            jsonArray.add(orderJsonData.toQueryJson());
        }
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(),pageInfo.getPages(),jsonArray).toJson());
    }

    @ApiOperation(value = "订单分页查询",notes = "此接口分页查询订单")
    @PostMapping("/query")
    public ResultUtils queryOrder(@Validated @RequestBody AdminPageVo adminPageVo){
        PageInfo pageInfo = orderService.getMenusToUserId(adminPageVo.getPage(), adminPageVo.getLimit(), adminPageVo.getUserId());
        List<Order> orderList=pageInfo.getList();
        JSONArray jsonArray=new JSONArray();
        UserVirtualKey userVirtualKey=new UserVirtualKey();
        userVirtualKey.setUserid(adminPageVo.getUserId());
        UserVirtual userVirtual = userVirtualService.getUserByKey(userVirtualKey);
        OrderTypeKey orderTypeKey=new OrderTypeKey();
        OrderStatusKey orderStatusKey=new OrderStatusKey();
        CurrencyKey currencyKey=new CurrencyKey();
        for(int i=0;i<orderList.size();i++){
            Order order=orderList.get(i);
            currencyKey.setCurrencyid(order.getOrderCurrencyid());
            orderTypeKey.setOrdertypeid(order.getOrderStatusid());
            orderStatusKey.setOrderstatusid(order.getOrderStatusid());
            OrderJsonData orderJsonData=new OrderJsonData(order.getOrderid(),order.getOrderbuytime(),order.getOrderselltime(),currencyService.getCurrencyByKey(currencyKey).getCurrencyname(),order.getOrderCurrencynum(),order.getOrderprice(),orderTypeService.getOrderTypeByKey(orderTypeKey).getOrdertypename(),order.getOrdernumber(),orderStatusService.getOrderStatusByKey(orderStatusKey).getOrderstatusname(),userVirtual.getAccount());
            jsonArray.add(orderJsonData.toQueryJson());
        }
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(),pageInfo.getPages(),jsonArray).toJson());
    }

    @ApiOperation(value = "添加订单信息",notes = "此接口添加订单信息")
    @PostMapping("/insert")
    public ResultUtils insertOrder(@Validated @RequestBody OrderVo orderVo){
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
    public ResultUtils deleteOrder(@Validated @RequestBody OrderVo orderVo){
        OrderKey orderKey=new OrderKey();
        orderKey.setOrderid(orderVo.getOrderId());
        if(orderService.deleteByKey(orderKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改订单",notes = "此接口修改订单信息")
    @PostMapping("/update")
    public ResultUtils updateOrder(@Validated @RequestBody OrderVo orderVo){
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
