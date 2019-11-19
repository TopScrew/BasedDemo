package com.screw.springcloudserverconsumers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.screw.feign" })
@ComponentScan("com.screw")
public class SpringcloudServerConsumersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServerConsumersApplication.class, args);
    }

    @Bean  //想使用rest方式进行服务调用需用Bean的方式将restTemplate注册到Spring
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
