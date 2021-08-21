package com.suxch.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderConsulController {
    public static final String PAYMENT_URL = "http://consul-provide-order";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String getPaymentUrl() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
