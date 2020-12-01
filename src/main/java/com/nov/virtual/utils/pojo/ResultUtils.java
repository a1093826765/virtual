package com.nov.virtual.utils.pojo;


import com.alibaba.fastjson.JSONObject;

/**
 * 返回结果工具类
 * @author november
 */
public class ResultUtils {

    private Integer code;

    private String message;

    private Object data;

    public ResultUtils(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultUtils(){

    }

    public ResultUtils (ResultCode resultCode){
        this.code=resultCode.getCode();
        this.message=resultCode.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回成功
     * @return
     */
    public static ResultUtils success(){
        ResultUtils resultUtils=new ResultUtils(ResultCode.SUCCESS);
        return resultUtils;
    }

    /**
     * 返回成功,有data
     * @param data
     * @return
     */
    public static ResultUtils success(Object data){
        ResultUtils resultUtils=new ResultUtils(ResultCode.SUCCESS);
        resultUtils.setData(data);
        return resultUtils;
    }

    /**
     * 返回成功（自定义返回）
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResultUtils success(Integer code,String message,Object data){
        return new ResultUtils(code,message,data);
    }

    /**
     * 返回失败
     * @param resultCode
     * @return
     */
    public static ResultUtils fail(ResultCode resultCode){
        return new ResultUtils(resultCode);
    }

    /**
     * 返回失败（自定义返回）
     * @param code
     * @param message
     * @return
     */
    public static ResultUtils fail(Integer code,String message){
        ResultUtils resultUtils=new ResultUtils();
        resultUtils.setCode(code);
        resultUtils.setMessage(message);
        return resultUtils;
    }

    @Override
    public String toString() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.fluentPut("code",code);
        jsonObject.fluentPut("message",message);
        jsonObject.fluentPut("data",data);
        return jsonObject.toString();
    }
}
