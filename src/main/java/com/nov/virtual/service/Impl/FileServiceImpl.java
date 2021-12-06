package com.nov.virtual.service.Impl;

import com.nov.virtual.service.FileService;
import com.nov.virtual.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: november
 * Date: 2021/2/5 2:34 下午
 */
@Service
public class FileServiceImpl implements FileService {

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description:覆盖更新文件
     * @author november
     * @CreateTime: 2021/4/6 3:20 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    @Override
    public void updateTxtFile(String fileName, String conTxt,String path,boolean t) {
        FileUtil.writeMethod(path+fileName,conTxt,t);
    }

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 读取文件
     * @author november
     * @CreateTime: 2021/4/6 3:20 下午
     * @UpdateTIme:
     * @param
     * @return
     */
    @Override
    public String queryTxtFilePath(String name,String path) {
        return FileUtil.readMethod(path+name+".txt");
    }

    /**
     * Created by IntelliJ IDEA.
     *
     * @param path
     * @return
     * @Description: 删除文件
     * @author november
     * @CreateTime: 2021/4/6 3:23 下午
     * @UpdateTIme:
     */
    @Override
    public boolean delete(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }

        if (file.isFile()) {
            return file.delete();
        } else {

            for (File filed : file.listFiles()) {
                delete(filed.getPath());
            }
        }
        return true;
    }

}
