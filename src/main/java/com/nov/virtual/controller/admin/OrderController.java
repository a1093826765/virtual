package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.bean.resultJsonData.OrderJsonData;
import com.nov.virtual.bean.resultJsonData.PageJsonData;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.*;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.*;
import com.nov.virtual.vo.admin.order.DeleteOrderVo;
import com.nov.virtual.vo.admin.order.InsertOrderVo;
import com.nov.virtual.vo.admin.order.UpdateOrderVo;
import com.nov.virtual.vo.config.AdminPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 管理员订单管理接口
 * @author november
 */
@Api(value = "管理员订单管理Controller",tags = {"管理员订单接口"})
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
            orderTypeKey.setOrdertypeid(order.getOrderTypeid());
            orderStatusKey.setOrderstatusid(order.getOrderStatusid());
            OrderJsonData orderJsonData=new OrderJsonData(order.getOrderid(),order.getOrderbuytime(),order.getOrderselltime(),currencyService.getCurrencyByKey(currencyKey).getCurrencyname(),order.getOrderCurrencynum(),order.getOrderprice(),orderTypeService.getOrderTypeByKey(orderTypeKey).getOrdertypename(),order.getOrdernumber(),orderStatusService.getOrderStatusByKey(orderStatusKey).getOrderstatusname(),userVirtualService.getUserByKey(userVirtualKey).getAccount());
            jsonArray.add(orderJsonData.toQueryJson());
        }
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(),pageInfo.getPages(),jsonArray,pageInfo.getTotal()).toJson());
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
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(),pageInfo.getPages(),jsonArray,pageInfo.getTotal()).toJson());
    }

    @ApiOperation(value = "添加订单信息",notes = "此接口添加订单信息")
    @PostMapping("/insert")
    public ResultUtils insertOrder(@Validated @RequestBody InsertOrderVo insertOrderVo){
        UserVirtualExample userVirtualExample=new UserVirtualExample();
        UserVirtualExample.Criteria userVirtualExampleCriteria = userVirtualExample.createCriteria();
        userVirtualExampleCriteria.andAccountEqualTo(insertOrderVo.getAccount());
        List<UserVirtual> userVirtualList = userVirtualService.getUserByExample(userVirtualExample);
        if (userVirtualList.size() > 0) {
            UserVirtual userVirtual = userVirtualList.get(0);
            Order order = new Order();
            order.setOrderCurrencyid(insertOrderVo.getOrderCurrencyId());
            order.setOrderCurrencynum(insertOrderVo.getOrderNum());
            order.setOrdernumber(insertOrderVo.getOrderNum());
            order.setOrderprice(insertOrderVo.getOrderPrice());
            order.setOrderStatusid(insertOrderVo.getOrderStatusId());
            order.setOrderTypeid(insertOrderVo.getOrderTypeId());
            if (insertOrderVo.getOrderTypeId() == 1) {
                order.setOrderbuytime(new Date());
            } else {
                order.setOrderselltime(new Date());
            }
            order.setOrderUserid(userVirtual.getUserid());
            if (orderService.save(order) == 1) {
                return ResultUtils.success(ResultCodeEnum.SUCCESS);
            }
        }else{
            return ResultUtils.fail(ResultCodeEnum.USER_NOT);
        }
            return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除订单",notes = "此接口删除订单信息")
    @PostMapping("/delete")
    public ResultUtils deleteOrder(@Validated @RequestBody DeleteOrderVo deleteOrderVo){
        OrderKey orderKey=new OrderKey();
        orderKey.setOrderid(deleteOrderVo.getOrderId());
        if(orderService.deleteByKey(orderKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改订单",notes = "此接口修改订单信息")
    @PostMapping("/update")
    public ResultUtils updateOrder(@Validated @RequestBody UpdateOrderVo updateOrderVo){
        UserVirtualExample userVirtualExample=new UserVirtualExample();
        UserVirtualExample.Criteria userVirtualExampleCriteria = userVirtualExample.createCriteria();
        userVirtualExampleCriteria.andAccountEqualTo(updateOrderVo.getAccount());
        List<UserVirtual> userVirtualList = userVirtualService.getUserByExample(userVirtualExample);
            if (userVirtualList.size() > 0) {
                OrderKey orderKey=new OrderKey();
                orderKey.setOrderid(updateOrderVo.getOrderId());
                Order order =orderService.getOrderByKey(orderKey);
                order.setOrderCurrencyid(updateOrderVo.getOrderCurrencyId());
                order.setOrderCurrencynum(updateOrderVo.getOrderCurrencyNum());
                order.setOrdernumber(updateOrderVo.getOrderNum());
                order.setOrderprice(updateOrderVo.getOrderPrice());
                order.setOrderStatusid(updateOrderVo.getOrderStatusId());
                order.setOrderTypeid(updateOrderVo.getOrderTypeId());
                if (orderService.updateByKey(order) == 1) {
                    return ResultUtils.success();
                }
            } else {
                return ResultUtils.fail(ResultCodeEnum.PARAM_IS_INVALID);
            }

        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }
}
