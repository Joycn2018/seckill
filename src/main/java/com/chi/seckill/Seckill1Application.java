package com.chi.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.chi.seckill.mapper")
@EnableSwagger2
@EnableTransactionManagement
public class Seckill1Application {

    public static void main(String[] args) {
        SpringApplication.run(Seckill1Application.class, args);
    }

}
