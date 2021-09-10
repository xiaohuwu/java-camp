package com.ktb.mapper;

import com.ktb.model.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> findAllOrders();
}
