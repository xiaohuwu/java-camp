package com.example.springboot_05_mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot_05_mybatis.entity.Orders;

public interface OrderService extends IService<Orders> {
  public IPage<Orders> findAllOrders(Page page);
}
