package com.nov.virtual.utils;

import com.nov.virtual.config.HadoopConfig;
import lombok.extern.slf4j.Slf4j;

import javax.xml.transform.Source;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * Created by IntelliJ IDEA.
 * @Description:
 * @Author: november
 * @CreateTime: 2021/4/6 3:03 下午
 * @UpdateTIme:
 */
@Slf4j
public class FileUtil {

    /**
     *
     * Created by IntelliJ IDEA.
     * @Description: 删除文件夹
     * @author november
     * @CreateTime: 2021/4/6 3:13 下午
     * @UpdateTIme:
     * @param
     * @return
     */
     public static boolean deleteFile(String path){
         File files = new File(path);
         if (files.isFile()) {
             return files.delete();
         } else {

             for (File file : files.listFiles()) {
                 deleteFile(file.getAbsolutePath());
             }
         }
         return  files.delete();
     }

    /**
     * 使用BufferedWriter类写文本文件（覆盖）
     */
    public static void writeMethod(String fileNamePath, String conTxt,boolean t) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(fileNamePath,t), StandardCharsets.UTF_8));
            out.write(new String(conTxt.getBytes(StandardCharsets.UTF_8)));
            out.newLine();  //注意\n不一定在各种计算机上都能产生换行的效果
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 使用BufferedReader类读文本文件
     */
    public static String readMethod(String fileNamePath) {
        String line;
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileNamePath), StandardCharsets.UTF_8));
            while ((line = in.readLine()) != null) {
                str.append(line+",");
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = readMethod("/Users/november/Desktop/virtual/BTC.txt");
        String[] split = s.split(",");
        for(String a:split){
            if(a.substring(0,1).equals("0")){
                System.out.println(Double.parseDouble(a.substring(1)));
            }
        }
    }
}
