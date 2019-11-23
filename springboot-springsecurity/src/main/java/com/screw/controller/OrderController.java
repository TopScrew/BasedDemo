package com.screw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class OrderController {

    @GetMapping("/index")
    public String index(){

        return "index";
    }

    @GetMapping("/queryOrder")
    public String queryOrder(){

        return "query";
    }

    @GetMapping("/addOrder")
    public String addOrder(){

        return "add";
    }

    @GetMapping("/delOrder")
    public String delOrder(){

        return "del";
    }


}
