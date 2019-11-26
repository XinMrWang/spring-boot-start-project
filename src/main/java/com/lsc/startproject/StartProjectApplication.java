package com.lsc.startproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author halink
 */
@SpringBootApplication
@MapperScan("com.lsc.startproject.modular.mapper")
public class StartProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartProjectApplication.class, args);
    }

}
