package com.suxch.springcloud.service;

import com.suxch.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);
    Payment queryById(long id);
}
