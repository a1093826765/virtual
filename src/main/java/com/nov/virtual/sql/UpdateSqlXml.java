package com.nov.virtual.sql;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.Class.forName;


/**
 * 获取配置文件信息写入sqlTest.txt
 * @author november
 */
public class UpdateSqlXml {
    private static String databaseName = "virtual";

    public static void main(String[] args) {
        sqlXmlTxt();
    }

    //查询数据库所有的表明并配置到generatorConfig.xml中
    public static void sqlXmlTxt() {
        try {
            String re = "";
            forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + databaseName + "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
            String userName = "root";
            String password = "a2288311";
            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement sta = conn.createStatement();
            ResultSet resultSet = sta.executeQuery("select table_name from information_schema.tables where table_schema='"+databaseName+"';");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                System.out.println(name);
                String Name = name.substring(0, 1).toUpperCase().concat(name.substring(1).toLowerCase());
                re = re + " <table tableName=\"" + name + "\" domainObjectName=\"" + Name + "\" enableSelectByExample=\"true\" enableDeleteByExample=\"true\"\n" +
                        "enableCountByExample=\"true\" enableUpdateByExample=\"true\"\n" +
                        "delimitIdentifiers=\"true\"/>\n";
            }
            FileWriter f_writer = new FileWriter("/Users/november/Desktop/file/sqlTest.txt");
            BufferedWriter writer = new BufferedWriter(f_writer);
            writer.write(re);
            writer.close();
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
