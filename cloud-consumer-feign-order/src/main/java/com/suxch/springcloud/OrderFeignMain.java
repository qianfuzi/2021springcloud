package com.suxch.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: suxch
 * @description:
 * @date: 2021/8/21 0021 下午 3:42
 */
@SpringBootApplication
@EnableFeignClients //激活Feign
public class OrderFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain.class, args);
    }
}
