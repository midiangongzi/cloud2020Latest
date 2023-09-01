package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:MyBatisConfig
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/9/1 19:42
 * @Version 1.0
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
