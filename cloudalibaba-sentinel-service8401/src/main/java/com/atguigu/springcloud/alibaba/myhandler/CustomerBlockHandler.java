package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * ClassName:CustomerBlockHandler
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/9/1 15:29
 * @Version 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444,"按客户自定义,global handlerException");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444,"按客户自定义,global handlerException2");
    }
}
