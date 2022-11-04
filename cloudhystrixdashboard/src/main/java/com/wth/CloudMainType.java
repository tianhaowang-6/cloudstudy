package com.wth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

// 启用 Hystrix 仪表盘功能
@EnableHystrixDashboard
@SpringBootApplication
public class CloudMainType {
    public static void main(String[] args) {
        SpringApplication.run(CloudMainType.class, args);
    }
}