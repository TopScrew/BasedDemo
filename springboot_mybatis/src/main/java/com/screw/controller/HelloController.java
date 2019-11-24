package com.screw.controller;

import com.screw.entity.User;
import com.screw.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @RequestMapping("/findByUser")
    public List<User> findByUser(String id){
        return userMapper.findByUser(id);
    }

    //不安全的OrderBy排序
    @RequestMapping("/orderBy")
    public List<User> orderBy(String columnName){
        return userMapper.orderBy(columnName);
    }

    //安全的OrderBy排序
    @RequestMapping("/SafeOrderBy")
    public List<User> SafeOrderBy(String columnName,String orderName){
        return userMapper.SafeOrderBy(columnName,orderName);
    }


}
