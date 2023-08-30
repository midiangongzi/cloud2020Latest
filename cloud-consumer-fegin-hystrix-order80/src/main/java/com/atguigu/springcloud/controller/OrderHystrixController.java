package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PayMentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:PaymentHystrixController
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/8/28 22:00
 * @Version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PayMentHystrixService payMentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
       String result = payMentHystrixService.paymentInfo_Ok(id);
       return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    //})
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 10 / 0;
        String result = payMentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }


    public String paymentInfo_TimeOutHandler(Integer id) {
        return "我是消费者80，对方支付系统繁忙，请10秒后再试或者自己运行出错请检查自己";
    }

    //下面是全局fallback
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试";
    }
}
