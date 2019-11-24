package com.screw.service.impl;

import com.screw.entity.User;
import com.screw.mapper.UserMapper;
//import com.screw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }


    @Override
    public List<User> findByUser(String id) {
        return userMapper.findByUser(id);
    }

    @Override
    public List<User> orderBy(String id) {
        return userMapper.orderBy(id);
    }

    @Override
    public List<User> SafeOrderBy(String columnName,String orderName) {
        return userMapper.SafeOrderBy(columnName,orderName);
    }



}
