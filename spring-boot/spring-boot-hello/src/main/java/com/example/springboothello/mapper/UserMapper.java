package com.example.springboothello.mapper;

import com.example.springboothello.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findByName(@Param("name") String name);

    int insert(@Param("name") String name, @Param("age") Integer age);
}
