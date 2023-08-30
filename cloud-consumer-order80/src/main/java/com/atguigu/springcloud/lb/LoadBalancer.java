package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * ClassName:LoadBalancer
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/8/28 16:17
 * @Version 1.0
 */
public interface LoadBalancer {
    ServiceInstance instance (List<ServiceInstance> ServiceInstance);
}
