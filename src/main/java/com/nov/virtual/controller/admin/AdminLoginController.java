package com.nov.virtual.controller.admin;



import com.nov.virtual.config.Address;
import com.nov.virtual.sql.model.UserVirtual;
import com.nov.virtual.sql.service.UserVirtualService;
import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import com.nov.virtual.utils.pojo.TokenUtils;
import com.nov.virtual.vo.admin.login.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员登录api
 * @author november
 */
@Api(value = "管理员登录Controller",tags = {"管理员登录接口"})
@RestController
@RequestMapping(value = "/api/admin/login",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class AdminLoginController {

    @Autowired
    private UserVirtualService userVirtualServiceService;

    /**
     * 用户登录
     * @param loginVo
     * @return
     */
    @ApiOperation(value = "管理员登录",notes = "此接口进行管理员登录，对账号密码进行验证")
    @PostMapping
    public ResultUtils adminLogin(@Validated @RequestBody LoginVo loginVo){
        // 查询账户是否存在（账户+密码）
        List<UserVirtual> userList = userVirtualServiceService.login(loginVo.getAccount(),loginVo.getPassword());
        if(userList.size()>0){
            UserVirtual userVirtual=userList.get(0);
            if(userVirtual.getUserUsertypeid()==2) {
                // 账户存在，登录成功
                return ResultUtils.success(TokenUtils.getToken(userVirtual.getUserid(), Address.TOKEN_SEC));
            }
        }
        // 账户或密码错误，登录失败
        return ResultUtils.fail(ResultCodeEnum.USER_LOGIN_ERROR);
    }
}
