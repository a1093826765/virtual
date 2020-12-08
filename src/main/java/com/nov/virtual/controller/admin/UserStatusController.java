package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.sql.model.UserStatus;
import com.nov.virtual.sql.model.UserStatusExample;
import com.nov.virtual.sql.model.UserStatusKey;
import com.nov.virtual.sql.service.UserStatusService;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.UserStatusVo;
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
@RequestMapping(value = "/api/admin/userStatus",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserStatusController {
    @Autowired
    UserStatusService userStatusService;

    @ApiOperation(value = "订单类型查询",notes = "此接口查询订单类型信息")
    @GetMapping("/query")
    public ResultUtils queryUser(){
        List<UserStatus> userStatusList = userStatusService.getUserStatusByExample(new UserStatusExample());
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<userStatusList.size();i++){
            UserStatus userStatus=userStatusList.get(i);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("userStatusId",userStatus.getUserstatusid());
            jsonObject.put("userStatusName",userStatus.getUserstatusname());
            jsonArray.add(jsonObject);
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加订单类型",notes = "此接口添加订单类型信息")
    @PostMapping("/insert")
    public ResultUtils insertUser(@Validated @RequestBody UserStatusVo userStatusVo){
        UserStatus userStatus =new UserStatus();
        userStatus.setUserstatusname(userStatusVo.getUserStatusName());
        if(userStatusService.save(userStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除订单类型",notes = "此接口删除订单类型信息")
    @PostMapping("/delete")
    public ResultUtils deleteUser(@Validated @RequestBody UserStatusVo userStatusVo){
        UserStatusKey userStatusKey=new UserStatusKey();
        userStatusKey.setUserstatusid(userStatusVo.getUserStatusId());
        if(userStatusService.deleteByKey(userStatusKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改订单类型",notes = "此接口修改订单类型信息")
    @PostMapping("/update")
    public ResultUtils updateUser(@Validated @RequestBody UserStatusVo userStatusVo){
        UserStatus userStatus =new UserStatus();
        userStatus.setUserstatusid(userStatusVo.getUserStatusId());
        userStatus.setUserstatusname(userStatusVo.getUserStatusName());
        if(userStatusService.updateByKey(userStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }
}
