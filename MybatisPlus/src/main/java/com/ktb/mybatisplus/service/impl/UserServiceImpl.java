package com.ktb.mybatisplus.service.impl;

import com.ktb.mybatisplus.entity.User;
import com.ktb.mybatisplus.mapper.UserMapper;
import com.ktb.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-10-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
