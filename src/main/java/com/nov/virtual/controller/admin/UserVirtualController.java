package com.nov.virtual.controller.admin;

import com.nov.virtual.sql.model.Order;
import com.nov.virtual.sql.model.OrderKey;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.model.UserVirtualKey;
import com.nov.virtual.sql.service.OrderService;
import com.nov.virtual.sql.service.UserVirtualService;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.AdminPageVo;
import com.nov.virtual.vo.OrderVo;
import com.nov.virtual.vo.UserVirtualVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 用户接口
 * @author november
 */
@Api(value = "用户Controller",tags = {"用户接口"})
@RestController
@RequestMapping(value = "/api/admin/order",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserVirtualController {
    @Autowired
    UserVirtualService userVirtualService;

    @ApiOperation(value = "用户分页查询",notes = "此接口分页查询用户")
    @PostMapping("/query")
    public ResultUtils queryCurrency(@Validated @RequestBody AdminPageVo adminPageVo){
        return ResultUtils.success(userVirtualService.getMenusToUserId(adminPageVo.getPage(),adminPageVo.getLimit(),adminPageVo.getUserId()));
    }

    @ApiOperation(value = "添加用户信息",notes = "此接口添加用户信息")
    @PostMapping("/insert")
    public ResultUtils insertCurrency(@Validated @RequestBody UserVirtualVo userVirtualVo){
        UserVirtual userVirtual=new UserVirtual();
        userVirtual.setUserUsertypeid(userVirtualVo.getUserTypeId());
        userVirtual.setRegistertime(new Date());
        userVirtual.setUserUserstautsid(userVirtualVo.getUserStatusId());
        userVirtual.setUsername(userVirtualVo.getUserName());
        userVirtual.setPassword(userVirtualVo.getPassword());
        userVirtual.setMoney(userVirtualVo.getMoney());
        if(userVirtualService.save(userVirtual)==1){
            return ResultUtils.fail(ResultCode.SUCCESS);
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除用户",notes = "此接口删除用户信息")
    @PostMapping("/delete")
    public ResultUtils deleteCurrency(@Validated @RequestBody UserVirtualVo userVirtualVo){
        UserVirtualKey userVirtualKey=new UserVirtualKey();
        userVirtualKey.setUserid(userVirtualVo.getUserId());
        if(userVirtualService.deleteByKey(userVirtualKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改用户",notes = "此接口修改用户信息")
    @PostMapping("/update")
    public ResultUtils updateCurrency(@Validated @RequestBody UserVirtualVo userVirtualVo){
        UserVirtual userVirtual=new UserVirtual();
        userVirtual.setUserid(userVirtualVo.getUserId());
        userVirtual.setUserUsertypeid(userVirtualVo.getUserTypeId());
        userVirtual.setRegistertime(new Date());
        userVirtual.setUserUserstautsid(userVirtualVo.getUserStatusId());
        userVirtual.setUsername(userVirtualVo.getUserName());
        userVirtual.setPassword(userVirtualVo.getPassword());
        userVirtual.setMoney(userVirtualVo.getMoney());
        if(userVirtualService.updateByKey(userVirtual)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }
}
