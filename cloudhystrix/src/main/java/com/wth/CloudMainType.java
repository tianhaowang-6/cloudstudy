package com.wth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

// 启用断路器功能
@EnableCircuitBreaker
@SpringBootApplication
public class CloudMainType {
    public static void main(String[] args) {
        SpringApplication.run(CloudMainType.class, args);
    }
}
