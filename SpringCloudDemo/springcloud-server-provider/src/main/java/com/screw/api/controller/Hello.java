package com.screw.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api("Swagger 注解描述") //这个在Swagger UI上不会显示
@RestController
public class Hello {

    @ApiOperation("Swagger 演示接口")
    @GetMapping(value = "/test")
    public String sayHello(){

        return "------,我是服务提供者";
    }

   

}
