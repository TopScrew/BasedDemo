package com.screw.sprincloud_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer//开启ConfigServer
public class SprincloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprincloudConfigApplication.class, args);
    }

}
