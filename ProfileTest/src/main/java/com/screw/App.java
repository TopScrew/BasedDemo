package com.screw;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 // */
@Configuration
@ComponentScan(basePackages = {"com.screw"})
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(com.screw.App.class);
        Person p = context.getBean(Person.class);
        p.speak();
    }
}
