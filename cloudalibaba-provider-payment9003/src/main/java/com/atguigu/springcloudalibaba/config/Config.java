package com.atguigu.springcloudalibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:Config
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/8/31 20:33
 * @Version 1.0
 */
@Configuration
public class Config {
    @Bean
    @LoadBalanced
    public RestTemplate getRestemplate() {
        return new RestTemplate();
    }

}
