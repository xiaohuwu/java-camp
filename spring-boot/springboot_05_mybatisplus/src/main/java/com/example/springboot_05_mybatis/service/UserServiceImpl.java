package com.example.springboot_05_mybatis.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_05_mybatis.entity.Orders;
import com.example.springboot_05_mybatis.entity.User;
import com.example.springboot_05_mybatis.mapper.OrderMapper;
import com.example.springboot_05_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public User test() {
        User user = baseMapper.selectById(3);
        LambdaQueryWrapper<Orders> orderLambdaQueryWrapper = new LambdaQueryWrapper<Orders>();
        orderLambdaQueryWrapper.eq(Orders::getId, user.getId());
        List<Orders> orders = orderMapper.selectList(orderLambdaQueryWrapper);
        user.setOrders(orders);
        return user;
    }

}
