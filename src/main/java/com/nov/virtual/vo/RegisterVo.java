package com.nov.virtual.vo;

import lombok.Data;

/**
 * 存储用户注册信息
 * @author november
 */
@Data
public class RegisterVo {
    private String account;
    private String password;
    private String userName;
}
