package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * ClassName:PaymentFallBackService
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/9/1 16:32
 * @Version 1.0
 */
@Component
public class PaymentFallBackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444444,"服务降级返回-----来自于PaymentFallBackService",new Payment(id,"errorSerial"));
    }
}
