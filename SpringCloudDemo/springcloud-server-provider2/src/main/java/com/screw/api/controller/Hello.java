package com.screw.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Hello {

    @Value("${testinfo}")
    private String testinfo;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String sayHello(){
        return "读取的配置信息："+testinfo;
    }

}
