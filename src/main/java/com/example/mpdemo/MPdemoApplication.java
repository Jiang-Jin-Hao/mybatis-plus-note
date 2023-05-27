package com.example.mpdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mpdemo.mapper")
public class MPdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MPdemoApplication.class, args);
    }

}
