package com.suxch.springcloud.controller;

import com.suxch.springcloud.pojo.CommonResult;
import com.suxch.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {
    //调用支付服务的id和端口
    public static final String PAYMENT_URL ="http://provide-payment";
    @Autowired
    private RestTemplate restTemplate;
    //支付订单
    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }
    //通过id获取支付订单
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
