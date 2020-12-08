package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nov.virtual.sql.model.UserType;
import com.nov.virtual.sql.model.UserTypeExample;
import com.nov.virtual.sql.model.UserTypeKey;
import com.nov.virtual.sql.service.UserTypeService;
import com.nov.virtual.utils.pojo.ResultCode;
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
 * 订单类型接口
 * @author november
 */
@Api(value = "订单类型Controller",tags = {"订单类型接口"})
@RestController
@RequestMapping(value = "/api/admin/userType",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    @ApiOperation(value = "订单类型查询",notes = "此接口查询订单类型信息")
    @GetMapping("/query")
    public ResultUtils queryCurrency(){
        List<UserType> userTypeList = userTypeService.getUserTypeByExample(new UserTypeExample());
        JSONArray jsonArray=new JSONArray();
        for(int i=0;i<userTypeList.size();i++){
            UserType userType=userTypeList.get(i);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("userTypeId",userType.getUsertypeid());
            jsonObject.put("userTypeName",userType.getUsertypename());
            jsonArray.add(jsonObject);
        }
        return ResultUtils.success(jsonArray);
    }

    @ApiOperation(value = "添加订单类型",notes = "此接口添加订单类型信息")
    @PostMapping("/insert")
    public ResultUtils insertCurrency(@Validated @RequestBody UserTypeVo userTypeVo){
        UserType userType =new UserType();
        userType.setUsertypename(userTypeVo.getUserTypeName());
        if(userTypeService.save(userType)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "删除订单类型",notes = "此接口删除订单类型信息")
    @PostMapping("/delete")
    public ResultUtils deleteCurrency(@Validated @RequestBody UserTypeVo userTypeVo){
        UserTypeKey userTypeKey=new UserTypeKey();
        userTypeKey.setUsertypeid(userTypeVo.getUserTypeId());
        if(userTypeService.deleteByKey(userTypeKey)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改订单类型",notes = "此接口修改订单类型信息")
    @PostMapping("/update")
    public ResultUtils updateCurrency(@Validated @RequestBody UserTypeVo userTypeVo){
        UserType userType =new UserType();
        userType.setUsertypeid(userTypeVo.getUserTypeId());
        userType.setUsertypename(userTypeVo.getUserTypeName());
        if(userTypeService.updateByKey(userType)==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }
}
