package com.nov.virtual.vo;

import lombok.Data;

/**
 * 存储用户登录信息
 * @author november
 */

@Data
public class LoginVo {
    private String account;
    private String password;
}
