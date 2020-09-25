package com.halink.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 启动类
 *
 * @author halink
 */
@EnableOpenApi
@SpringBootApplication
@MapperScan("com.halink.scaffold.modular.mapper")
public class StartProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartProjectApplication.class, args);
    }

}
