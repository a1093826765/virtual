package com.nov.virtual.exceptions;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.nov.virtual.utils.pojo.ResultCode;
import com.nov.virtual.utils.pojo.ResultUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 * @author november
 */
@ControllerAdvice
public class GloabllExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e){
        e.printStackTrace();
        return new ResultUtils(ResultCode.SYSTEM_ERROR);
    }

    /**
     * 参数为空异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handlerException(HttpMessageNotReadableException e){
        return new ResultUtils(ResultCode.PARAM_IS_BLANK);
    }

}

