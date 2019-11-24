package com.screw.mapper;

import com.screw.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> findAll();

    List<User> findByUser(String id);

    List<User> orderBy(String columnName);
    List<User> SafeOrderBy(String columnName,String orderName);
}

