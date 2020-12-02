package com.nov.virtual.controller;

import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.service.UserVirtualService;
import com.nov.virtual.config.Address;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.utils.pojo.TokenUtils;
import com.nov.virtual.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户登录api
 * @author november
 */
@Api(value = "用户登录Controller",tags = {"用户登录接口"})
@RestController
@RequestMapping(value = "/api/login",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Autowired
    private UserVirtualService userVirtualServiceService;

    /**
     * 用户登录
     * @param loginVo
     * @return
     */
    @ApiOperation(value = "用户登录",notes = "此接口进行用户登录，对账号密码进行验证")
    @PostMapping
    public ResultUtils login(@Validated @RequestBody LoginVo loginVo){
        // 查询账户是否存在（账户+密码）
        List<UserVirtual> userList = userVirtualServiceService.login(loginVo.getAccount(),loginVo.getPassword());
        if(userList.size()>0){
            UserVirtual userVirtual=userList.get(0);
            // 账户存在，登录成功
            return ResultUtils.success(TokenUtils.getToken(userVirtual.getUserid(), Address.TOKEN_SEC));
        }else{
            // 账户或密码错误，登录失败
            return ResultUtils.fail(ResultCode.USER_LOGIN_ERROR);
        }
    }
}
