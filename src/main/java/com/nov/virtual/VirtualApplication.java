package com.nov.virtual;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author november
 */
@SpringBootApplication
//@EnableTransactionManagement
@MapperScan("com.nov.virtual.sql.mapper")
@EnableSwagger2
//@ComponentScan(basePackages = "com.nov.virtual.sql.*")
//@ServletComponentScan(basePackages = "com.nov.virtual.controller")
public class VirtualApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirtualApplication.class, args);
    }
}
