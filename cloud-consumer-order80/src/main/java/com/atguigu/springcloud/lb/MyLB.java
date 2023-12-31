package com.atguigu.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:MyLB
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/8/28 16:19
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 :current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> ServiceInstance) {
        int index = getAndIncrement() % ServiceInstance.size();
        return ServiceInstance.get(index);
    }
}
