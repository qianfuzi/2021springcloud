package com.suxch.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: suxch
 * @description: 自定义负载方式
 * @date: 2021/8/21 0021 下午 2:44
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        //随机方式
        return new RoundRobinRule();
    }
}
