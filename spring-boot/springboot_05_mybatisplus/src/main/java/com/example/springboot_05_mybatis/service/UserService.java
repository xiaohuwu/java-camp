package com.example.springboot_05_mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot_05_mybatis.entity.Orders;
import com.example.springboot_05_mybatis.entity.User;

public interface UserService extends IService<User> {
   public User test();
}
