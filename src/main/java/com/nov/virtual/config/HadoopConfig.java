package com.nov.virtual.config;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: november
 * @CreateTime: 2021/4/6 2:48 下午
 * @UpdateTIme:
 */
@Data
public class HadoopConfig {
    //当前价格
    public static Double NOW_MONEY;

    //hadoop文件输入地址
    public static final String HADOOP_INPUT_FILE="/root/apps/txt/virtual/hadoop/";

    //hadoop文件输出地址
    public static final String HADOOP_OUTPUT_FILE="/root/apps/txt/virtual/hadoop/out.txt";

    //cp地址
    public static final String CP_OUTPUT_FILE="/root/apps/txt/virtual/";


}
