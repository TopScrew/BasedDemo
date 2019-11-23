package com.screw.springbootspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.screw")
public class SpringbootSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringsecurityApplication.class, args);
    }

}
