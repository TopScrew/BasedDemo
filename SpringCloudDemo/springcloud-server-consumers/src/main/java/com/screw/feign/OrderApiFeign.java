package com.screw.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//name为注册的服务名
@FeignClient(name = "app-screw-hello")
public interface OrderApiFeign {

    @GetMapping(value = "/test")
    public String sayHello();

}
