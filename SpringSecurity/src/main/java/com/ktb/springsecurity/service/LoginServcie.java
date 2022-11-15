package com.ktb.springsecurity.service;

import com.ktb.springsecurity.entity.User;
import com.ktb.springsecurity.response.ResponseResult;

public interface LoginServcie {

    ResponseResult login(User user);
}
