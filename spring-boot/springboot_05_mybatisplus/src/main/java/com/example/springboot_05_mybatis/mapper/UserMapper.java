package com.example.springboot_05_mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.springboot_05_mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User findMyUserByWrapper(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
