package com.nov.virtual.service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: november
 * Date: 2021/2/5 2:30 下午
 */
public interface FileService {
    /**
     * 写入生成文件(覆盖)
     * @param fileName
     * @param cmdJson
     */
    void updateTxtFile(String fileName, String cmdJson, String path,boolean t);

    /**
     * 根据name查询文件
     * @param name
     * @return
     */
    String queryTxtFilePath(String name,String path);

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 删除文件
     * @author november
     * @CreateTime: 2021/4/6 3:23 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    boolean delete(String path);

}
