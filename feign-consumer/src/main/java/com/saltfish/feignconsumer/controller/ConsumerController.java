package com.saltfish.feignconsumer.controller;

import com.saltfish.feignconsumer.entity.User;
import com.saltfish.feignconsumer.service.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 * 消费者
 * spring-cloud
 *
 * @Date: 2019/2/18 21:33
 * @Author: James Lin
 * @Version: 1.0
 */
@RestController
public class ConsumerController {
    @Resource
    ConsumerService consumerService;
    @GetMapping(value = "/feign-consumer")
    public String helloConsumer() {
        return consumerService.hello();
    }
    @GetMapping(value = "/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();

        sb.append(consumerService.hello()).append("\n");
        sb.append(consumerService.hello("saltfish")).append("\n");
        sb.append(consumerService.hello(new User("saltfish", 18))).append("\n");
        sb.append(consumerService.hello("saltfish", 18)).append("\n");

        return sb.toString();
    }

}
