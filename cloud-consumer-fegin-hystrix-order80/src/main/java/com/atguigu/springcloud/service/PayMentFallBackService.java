package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * ClassName:PayMentFallBackService
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/8/29 9:02
 * @Version 1.0
 */
@Component
public class PayMentFallBackService  implements PayMentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PayMentFallBackService fall back  paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PayMentFallBackService  paymentInfo_TimeOut";
    }
}
