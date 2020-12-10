package com.nov.virtual.controller.web;

import com.nov.virtual.sql.service.UserVirtualService;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.vo.RegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户注册api
 * @author november
 */
@Api(value = "用户注册Controller",tags = {"用户注册接口"})
@RestController
@RequestMapping(value = "/api/web/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

    @Autowired
    private UserVirtualService userVirtualService;

    /**
     * 用户注册
     * @param registerVo
     * @return
     */
    @ApiOperation(value = "用户登录",notes = "此接口进行用户注册，添加用户信息")
    @PostMapping
    public ResultUtils register(@Validated @RequestBody RegisterVo registerVo){
        if(userVirtualService.register(registerVo.getAccount(),registerVo.getPassword(),registerVo.getPassword())==1){
            return ResultUtils.success();
        }
        return ResultUtils.fail(ResultCode.SYSTEM_ERROR);
    }
}