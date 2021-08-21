package com.suxch.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: suxch
 * @description: feignClient配置日志级别
 * @date: 2021/8/21 0021 下午 9:39
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLever() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
