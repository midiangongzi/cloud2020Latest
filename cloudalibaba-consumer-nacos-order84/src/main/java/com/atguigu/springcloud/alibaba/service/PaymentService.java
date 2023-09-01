package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.service.impl.PaymentFallBackService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName:PaymentService
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/9/1 16:30
 * @Version 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallBackService.class)
public interface PaymentService {

      @GetMapping(value = "/paymentSQL/{id}")
      public CommonResult<Payment> paymentSQL(@PathVariable ("id") Long id);

}
