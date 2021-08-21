package com.suxch.springcloud.controller;

import com.suxch.springcloud.pojo.CommonResult;
import com.suxch.springcloud.pojo.Payment;
import com.suxch.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("******************插入成功*********************" + i);
        if (i > 0) {
            return new CommonResult(200, "插入数据库成功", i);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*********" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败", null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("*************注册到eureka中的服务有：" + s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("provide-payment");
        for (ServiceInstance s : instances) {
            log.info("*****当前服务的实例有" + s.getServiceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri());

        }
        return this.discoveryClient;
    }

    @GetMapping("/timeout")
    public String paymentFeignTimeOut() throws InterruptedException {
        //模拟超时
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }
}
