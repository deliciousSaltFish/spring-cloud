package com.saltfish.eurekaclient.controller;

import com.saltfish.eurekaclient.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description:
 * 控制器
 * spring-cloud
 *
 * @Date: 2019/2/17 23:27
 * @Author: James Lin
 * @Version: 1.0
 */
@RestController
public class Controller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private DiscoveryClient client;
    String helloString="已进入Controller";
    @RequestMapping("/info")
    public String info() {
        logger.info(helloString);
        return helloString;
    }
    @RequestMapping("/hello")
    public String sayHello() {
        logger.info(helloString);
        return helloString;
    }
    @RequestMapping("/hello1")
    public String sayHello1() {
        logger.info(helloString+"1");
        return helloString;
    }
    @RequestMapping("/hello2")
    public User sayHello2(@RequestHeader String name, @RequestHeader Integer age) {
        logger.info(helloString+"2");
        return new User("saltfish", 26);
//        return helloString;
    }
    @PostMapping("/hello3")
    public String sayHello3(@RequestBody User user) {
        logger.info(helloString+"3");
        return helloString;
    }
}
