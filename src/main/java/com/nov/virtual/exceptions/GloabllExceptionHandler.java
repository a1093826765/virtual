package com.nov.virtual.exceptions;

import com.nov.virtual.enums.ResultCodeEnum;
import com.nov.virtual.utils.pojo.ResultUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
        return new ResultUtils(ResultCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 参数为空异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handlerException(HttpMessageNotReadableException e){
        return new ResultUtils(ResultCodeEnum.PARAM_IS_INVALID);
    }

    /**
     * 参数异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handlerException(HttpMediaTypeNotSupportedException e){
        return new ResultUtils(ResultCodeEnum.PARAM_IS_INVALID);
    }

    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handlerException(HttpRequestMethodNotSupportedException e){
        return new ResultUtils(ResultCodeEnum.USER_RE);
    }

}

