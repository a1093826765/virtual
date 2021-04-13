package com.nov.virtual.controller.publicController;

import com.alibaba.fastjson.JSONArray;
import com.nov.virtual.bean.resultJsonData.UserTypeJsonData;
import com.nov.virtual.sql.model.UserType;
import com.nov.virtual.sql.model.UserTypeExample;
import com.nov.virtual.sql.model.UserTypeKey;
import com.nov.virtual.sql.service.UserTypeService;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.UserTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户类型接口
 * @author november
 */
@Api(value = "用户类型Controller",tags = {"用户类型接口"})
@RestController
@RequestMapping(value = "/api/public/userType",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    @ApiOperation(value = "用户类型查询",notes = "此接口查询用户类型信息")
    @PostMapping("/query")
    public ResultUtils queryUser(){
        List<UserType> userTypeList = userTypeService.getUserTypeByExample(new UserTypeExample());
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<userTypeList.size();i++){
            UserType userType=userTypeList.get(i);
            UserTypeJsonData userTypeJsonData=new UserTypeJsonData(userType.getUsertypeid(),userType.getUsertypename());
            jsonArray.add(userTypeJsonData.toQueryJson());
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加用户类型",notes = "此接口添加用户类型信息")
    @PostMapping("/insert")
    public ResultUtils insertUser(@Validated @RequestBody UserTypeVo userTypeVo){
        UserType userType =new UserType();
        userType.setUsertypename(userTypeVo.getUserTypeName());
        if(userTypeService.save(userType)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除用户类型",notes = "此接口删除用户类型信息")
    @PostMapping("/delete")
    public ResultUtils deleteUser(@Validated @RequestBody UserTypeVo userTypeVo){
        UserTypeKey userTypeKey=new UserTypeKey();
        userTypeKey.setUsertypeid(userTypeVo.getUserTypeId());
        if(userTypeService.deleteByKey(userTypeKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改用户类型",notes = "此接口修改用户类型信息")
    @PostMapping("/update")
    public ResultUtils updateUser(@Validated @RequestBody UserTypeVo userTypeVo){
        UserType userType =new UserType();
        userType.setUsertypeid(userTypeVo.getUserTypeId());
        userType.setUsertypename(userTypeVo.getUserTypeName());
        if(userTypeService.updateByKey(userType)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCodeEnum.SYSTEM_ERROR);
    }
}
