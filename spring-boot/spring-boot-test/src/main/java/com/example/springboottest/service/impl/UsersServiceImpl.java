package com.example.springboottest.service.impl;

import com.example.springboottest.entity.User;
import com.example.springboottest.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboottest.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-08-26
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
