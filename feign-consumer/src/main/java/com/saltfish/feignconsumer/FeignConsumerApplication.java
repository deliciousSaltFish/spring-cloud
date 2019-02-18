package com.saltfish.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients            //开启Feign的支持功能
@EnableDiscoveryClient        //表明该应用是Eureka客户端
@EnableCircuitBreaker    //开启断路器功能
@SpringBootApplication
public class FeignConsumerApplication {
    @Bean
    @LoadBalanced
        //注解开启客户端负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

}
