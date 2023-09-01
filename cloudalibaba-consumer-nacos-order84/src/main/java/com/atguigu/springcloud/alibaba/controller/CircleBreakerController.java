package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName:CircleBreakerController
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/9/1 15:59
 * @Version 1.0
 */
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        }else if (result.getData() == null) {
            throw new NullPointerException("空指针异常，没有对应的记录");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable ("id") Long id,Throwable e) {
        Payment payment = new Payment(id,null);
        return new CommonResult(444,"兜底异常handlerFallback,Exception内容" + e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable ("id") Long id,Throwable e) {
        Payment payment = new Payment(id,null);
        return new CommonResult(444,"无此流水,blockHandler,Exception内容" + e.getMessage(),payment);
    }
    //==================OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        if(id == 4) {
            throw new RuntimeException("没有该id");
        }
        return paymentService.paymentSQL(id);
    }



}
