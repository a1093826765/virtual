package com.nov.virtual.controller.publicController;

import com.alibaba.fastjson.JSONArray;
import com.nov.virtual.bean.resultJsonData.UserStatusJsonData;
import com.nov.virtual.sql.model.UserStatus;
import com.nov.virtual.sql.model.UserStatusExample;
import com.nov.virtual.sql.model.UserStatusKey;
import com.nov.virtual.sql.service.UserStatusService;
import com.nov.virtual.enums.ResultCodeEnum;
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
 * 用户状态接口
 * @author november
 */
@Api(value = "公共用户状态Controller",tags = {"公共用户状态接口"})
@RestController
@RequestMapping(value = "/api/public/userStatus",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserStatusController {
    @Autowired
    UserStatusService userStatusService;

    @ApiOperation(value = "用户状态查询",notes = "此接口查询用户状态信息")
    @PostMapping("/query")
    public ResultUtils queryUser(){
        List<UserStatus> userStatusList = userStatusService.getUserStatusByExample(new UserStatusExample());
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<userStatusList.size();i++){
            UserStatus userStatus=userStatusList.get(i);
            UserStatusJsonData userStatusJsonData=new UserStatusJsonData(userStatus.getUserstatusid(),userStatus.getUserstatusname());
            jsonArray.add(userStatusJsonData.toQueryJson());
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加用户状态",notes = "此接口添加用户状态信息")
    @PostMapping("/insert")
    public ResultUtils insertUser(@Validated @RequestBody UserStatusVo userStatusVo){
        UserStatus userStatus =new UserStatus();
        userStatus.setUserstatusname(userStatusVo.getUserStatusName());
        if(userStatusService.save(userStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除用户状态",notes = "此接口删除用户状态信息")
    @PostMapping("/delete")
    public ResultUtils deleteUser(@Validated @RequestBody UserStatusVo userStatusVo){
        UserStatusKey userStatusKey=new UserStatusKey();
        userStatusKey.setUserstatusid(userStatusVo.getUserStatusId());
        if(userStatusService.deleteByKey(userStatusKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改用户状态",notes = "此接口修改用户状态信息")
    @PostMapping("/update")
    public ResultUtils updateUser(@Validated @RequestBody UserStatusVo userStatusVo){
        UserStatus userStatus =new UserStatus();
        userStatus.setUserstatusid(userStatusVo.getUserStatusId());
        userStatus.setUserstatusname(userStatusVo.getUserStatusName());
        if(userStatusService.updateByKey(userStatus)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }
}
