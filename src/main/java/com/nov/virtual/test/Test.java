package com.nov.virtual.test;

import com.nov.virtual.utils.pojo.ResultUtils;

import java.util.HashMap;

/**
 * 测试
 * @author november
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String,String> data=new HashMap<>();
        data.put("c1","c2");
        ResultUtils success = ResultUtils.success(data);
        System.out.println(success);
    }
}
