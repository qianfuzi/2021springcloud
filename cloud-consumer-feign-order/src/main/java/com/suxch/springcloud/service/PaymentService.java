package com.suxch.springcloud.service;

import com.suxch.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: suxch
 * @description:
 * @date: 2021/8/21 0021 下午 3:46
 */
@ComponentScan
@FeignClient(value = "provide-payment")//使用Feign
public interface PaymentService {
    /**
     * 通过id获取
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult queryById2(@PathVariable("id") Long id);

    /**
     * 模拟超时
     * @return serverPort
     */
    @GetMapping("/payment/timeout")
    public String paymentTimeOut()throws InterruptedException;
}
