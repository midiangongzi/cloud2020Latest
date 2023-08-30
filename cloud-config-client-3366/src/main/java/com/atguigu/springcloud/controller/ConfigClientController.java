package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ConfigClientController
 * Description:
 *
 * @Author 李高瞻
 * @Create 2023/8/30 13:45
 * @Version 1.0
 */
@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String configInfo() {
        return "serverPort:" + serverPort + "\t\n\n" + "configInfo:" + configInfo;
    }
}
