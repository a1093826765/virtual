package com.nov.virtual.service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: november
 * Date: 2021/1/27 1:04 上午
 */
public interface CommandService {
    /**
     * 执行命令
     * @param cmd
     * @return
     */
    String executeCmd(String cmd);
}
