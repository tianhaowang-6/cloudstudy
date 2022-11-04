package com.wth.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CloudConfig {

    @Bean
    @LoadBalanced // 这里需要配置一下
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
