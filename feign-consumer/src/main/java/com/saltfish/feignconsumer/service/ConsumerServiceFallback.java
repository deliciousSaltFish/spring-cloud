package com.saltfish.feignconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.saltfish.feignconsumer.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class ConsumerServiceFallback implements ConsumerService{
    @Resource
    RestTemplate restTemplate;
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }

    //启动熔断降级功能的回调函数
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello", String.class);
    }

    public String helloFallback() {
        return "error";
    }
}
