package com.ktb.mybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ktb.mybatisplus.model.Orders;
import com.ktb.mybatisplus.model.User;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Orders> {
}
