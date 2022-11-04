package com.wth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 启用 Feign 客户端功能
@EnableFeignClients
@SpringBootApplication
public class CloudMainType {
    public static void main(String[] args) {
        SpringApplication.run(CloudMainType.class, args);
    }
}
