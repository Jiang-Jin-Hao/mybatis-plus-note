package com.example.mpdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig implements WebMvcConfigurer {
    // 此类用于解决跨域问题

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**") // 允许跨域访问的路径
                .allowedOrigins("http://localhost:8080") // 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") // 运行跨域访问的方法
                .maxAge(168000) // 预检间隔时间
                .allowedHeaders("*") // 允许头部设置
                .allowCredentials(true); // 允许发送Cookie
    }
}
