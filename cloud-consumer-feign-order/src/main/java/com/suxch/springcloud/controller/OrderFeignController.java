package com.suxch.springcloud.controller;

import com.suxch.springcloud.pojo.CommonResult;
import com.suxch.springcloud.pojo.Payment;
import com.suxch.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: suxch
 * @description:
 * @date: 2021/8/21 0021 下午 3:59
 */
@RestController
@Slf4j
@RequestMapping("/consumer/feign")
public class OrderFeignController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult result = paymentService.queryById2(id);
        return result;
    }

    @GetMapping("/timeout")
    public String paymentTimeOut() throws InterruptedException {
        return paymentService.paymentTimeOut();
    }
}
