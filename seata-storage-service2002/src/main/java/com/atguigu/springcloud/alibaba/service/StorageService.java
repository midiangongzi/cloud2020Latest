package com.atguigu.springcloud.alibaba.service;

/**
 * ClassName:StorageService
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/9/1 20:21
 * @Version 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);

}
