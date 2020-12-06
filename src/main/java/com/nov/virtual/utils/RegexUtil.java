package com.nov.virtual.utils;

/**
 * 正则匹配
 * @author november
 */
public class RegexUtil {
    /**
     * 匹配邮箱
     * */
    public static void regexEmail(String str){
        System.out.println(str.matches("[0-9a-zA-Z]+_*[0-9a-zA-Z]*@[0-9a-zA-Z]+(\\.(com|cn)){1,2}"));
    }
    /**
     * 密码匹配
     * 6~12位 至少由 大写、小写、数字、空格中的三个
     * */
    public static boolean  regexPassword(String str){
        //判断参数是否为空
        if(str ==null){
            return false;
        }
        //判断密码位数
        if(!str.matches(".{6,12}")){
            return false;
        }
        int i = 0; // 记录字符种类
        //判断是否含有小写字母
        if(str.matches(".*[a-z].*")){
            i++;
        }
        //判断是否出现大写字母
        if(str.matches(".*[A-Z].*")){
            i++;
        }
        //判断是否出现数字
        if(str.matches(".*[0-9].*")){
            i++;
        }
        //判断是否出现空格
        if(str.matches(".*( ).*")){
            i++;
        }
        //判断字符个数
        if(i>2){
            return true;
        }
        return false;
    }

}
