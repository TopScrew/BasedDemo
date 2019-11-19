package com.screw.api.controller;

import com.screw.feign.OrderApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)
    public String getOrder(){
        // order 使用rpc 远程调用技术 调用 hello服务，底层都是用httpClient实现的
        //有两种调用方式，1是ip+端口直接调用 2.利用注册中心的别名的去调用
        String memberUrl = "http://app-screw-hello/test";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("会员服务调用hello服务,result:" + result);
        return "我是消费者，我调用了 ："+result;
    }

    @Autowired
    private OrderApiFeign orderApiFeign;

    @RequestMapping(value = "/getOrder2", method = RequestMethod.GET)
    public String getOrder2(){
        String result = orderApiFeign.sayHello();
        return "我是消费者，我调用了 :"+result;
    }

}
