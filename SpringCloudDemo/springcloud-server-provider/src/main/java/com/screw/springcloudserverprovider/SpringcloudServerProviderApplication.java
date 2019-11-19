package com.screw.springcloudserverprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.screw")
public class SpringcloudServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServerProviderApplication.class, args);
    }


}
