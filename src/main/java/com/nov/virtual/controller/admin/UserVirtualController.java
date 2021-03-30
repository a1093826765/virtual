package com.nov.virtual.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.nov.virtual.bean.resultJsonData.PageJsonData;
import com.nov.virtual.bean.resultJsonData.UserVirtualJsonData;
import com.nov.virtual.sql.model.*;
import com.nov.virtual.sql.service.UserStatusService;
import com.nov.virtual.sql.service.UserTypeService;
import com.nov.virtual.sql.service.UserVirtualService;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.*;
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
import java.util.List;

/**
 * 用户接口
 *
 * @author november
 */
@Api(value = "用户Controller", tags = {"用户接口"})
@RestController
@RequestMapping(value = "/api/admin/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserVirtualController {
    @Autowired
    UserVirtualService userVirtualService;

    @Autowired
    UserTypeService userTypeService;

    @Autowired
    UserStatusService userStatusService;

    @ApiOperation(value = "用户分页搜索", notes = "此接口分页搜索用户")
    @PostMapping("/search")
    public ResultUtils searchOrder(@Validated @RequestBody SearchVo searchVo) {
        UserVirtualExample userException = new UserVirtualExample();
        UserVirtualExample.Criteria criteria = userException.createCriteria();
        criteria.andUsernameLike(searchVo.getTitle());
        PageInfo pageInfo = userVirtualService.getMenus(searchVo.getPage(), searchVo.getLimit(), userException);
        List<UserVirtual> userVirtualList = pageInfo.getList();
        UserTypeKey userTypeKey = new UserTypeKey();
        UserStatusKey userStatusKey = new UserStatusKey();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < userVirtualList.size(); i++) {
            UserVirtual userVirtual = userVirtualList.get(i);
            userTypeKey.setUsertypeid(userVirtual.getUserUsertypeid());
            userStatusKey.setUserstatusid(userVirtual.getUserUserstautsid());
            UserVirtualJsonData userVirtualJsonData = new UserVirtualJsonData(userVirtual.getUserid(), userVirtual.getAccount(), userVirtual.getPassword(), userVirtual.getRegistertime(), userVirtual.getUsername(), userVirtual.getMoney(), userStatusService.getUserStatusByKey(userStatusKey).getUserstatusname(), userTypeService.getUserTypeByKey(userTypeKey).getUsertypename());
            jsonArray.add(userVirtualJsonData.toQueryJson());
        }
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(), pageInfo.getPages(), jsonArray,pageInfo.getTotal()));
    }


    @ApiOperation(value = "用户分页查询", notes = "此接口分页查询用户")
    @PostMapping("/query")
    public ResultUtils queryUser(@Validated @RequestBody PageVo pageVo) {
        PageInfo pageInfo = userVirtualService.getMenus(pageVo.getPage(), pageVo.getLimit(),new UserVirtualExample());
        List<UserVirtual> userVirtualList = pageInfo.getList();
        UserTypeKey userTypeKey = new UserTypeKey();
        UserStatusKey userStatusKey = new UserStatusKey();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < userVirtualList.size(); i++) {
            UserVirtual userVirtual = userVirtualList.get(i);
            userTypeKey.setUsertypeid(userVirtual.getUserUsertypeid());
            userStatusKey.setUserstatusid(userVirtual.getUserUserstautsid());
            UserVirtualJsonData userVirtualJsonData = new UserVirtualJsonData(userVirtual.getUserid(), userVirtual.getAccount(), userVirtual.getPassword(), userVirtual.getRegistertime(), userVirtual.getUsername(), userVirtual.getMoney(), userStatusService.getUserStatusByKey(userStatusKey).getUserstatusname(), userTypeService.getUserTypeByKey(userTypeKey).getUsertypename());
            jsonArray.add(userVirtualJsonData.toQueryJson());
        }
        return ResultUtils.success(new PageJsonData(pageInfo.getPageNum(), pageInfo.getPages(), jsonArray,pageInfo.getTotal()));
    }

    @ApiOperation(value = "添加用户信息", notes = "此接口添加用户信息")
    @PostMapping("/insert")
    public ResultUtils insertUser(@Validated @RequestBody UserVirtualVo userVirtualVo) {
        UserVirtualExample userVirtualExample=new UserVirtualExample();
        UserVirtualExample.Criteria criteria = userVirtualExample.createCriteria();
        criteria.andAccountEqualTo(userVirtualVo.getAccount());
        if(userVirtualService.getUserByExample(userVirtualExample).size()>0){
            UserVirtual userVirtual = new UserVirtual();
            userVirtual.setAccount(userVirtualVo.getAccount());
            userVirtual.setUserUsertypeid(userVirtualVo.getUserTypeId());
            userVirtual.setRegistertime(new Date());
            userVirtual.setUserUserstautsid(userVirtualVo.getUserStatusId());
            userVirtual.setUsername(userVirtualVo.getUserName());
            userVirtual.setPassword(userVirtualVo.getPassword());
            userVirtual.setMoney(userVirtualVo.getMoney());
            if (userVirtualService.save(userVirtual) == 1) {
                return ResultUtils.fail(ResultCode.SUCCESS);
            }
            return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
        }else{
            return ResultUtils.fail(ResultCode.USER_EXISTENCE_ERROR);
        }
    }

    @ApiOperation(value = "删除用户", notes = "此接口删除用户信息")
    @PostMapping("/delete")
    public ResultUtils deleteUser(@Validated @RequestBody UserVirtualVo userVirtualVo) {
        UserVirtualKey userVirtualKey = new UserVirtualKey();
        userVirtualKey.setUserid(userVirtualVo.getUserId());
        if (userVirtualService.deleteByKey(userVirtualKey) == 1) {
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }

    @ApiOperation(value = "修改用户", notes = "此接口修改用户信息")
    @PostMapping("/update")
    public ResultUtils updateUser(@Validated @RequestBody UserVirtualVo userVirtualVo) {
        UserVirtual userVirtual = new UserVirtual();
        userVirtual.setUserid(userVirtualVo.getUserId());
        userVirtual.setUserUsertypeid(userVirtualVo.getUserTypeId());
        userVirtual.setRegistertime(new Date());
        userVirtual.setUserUserstautsid(userVirtualVo.getUserStatusId());
        userVirtual.setUsername(userVirtualVo.getUserName());
        userVirtual.setPassword(userVirtualVo.getPassword());
        userVirtual.setMoney(userVirtualVo.getMoney());
        if (userVirtualService.updateByKey(userVirtual) == 1) {
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }
}
