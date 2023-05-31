package com.example.springboot_05_mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_05_mybatis.entity.Orders;
import com.example.springboot_05_mybatis.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public  IPage<Orders> findAllOrders(Page page) {
        return orderMapper.findAllOrders(page);
    }
}
