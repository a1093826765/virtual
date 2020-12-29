package com.nov.virtual.utils.pojo;


/**
 * api返回code枚举
 * @author november
 */

public enum  ResultCode {
    // 成功
    SUCCESS(200,"成功"),
    // 参数错误
    PARAM_IS_INVALID(205,"参数无效"),
    PARAM_IS_BLANK(206,"参数为空"),
    // 用户错误
    USER_NOT_LOGIN(201,"用户未登录"),
    USER_LOGIN_ERROR(202,"账户或密码错误"),
    TOKEN_ERROR(203,"token错误"),
    USER_EXISTENCE_ERROR(204,"用户已存在"),
    USER_RE(2000,"参数异常，请修改请求方式"),
    USER_NOT_MONEY(2001,"余额不足"),
    USER_NOT_CURRENCY_NUM(2002,"货币不足"),
    SYSTEM_ERROR(500,"系统异常，请稍后重试"),
    // websocket
    CONNECT_SUCCESS(200,"websocket连接成功");


    private Integer code;
    private String message;

    private ResultCode(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
