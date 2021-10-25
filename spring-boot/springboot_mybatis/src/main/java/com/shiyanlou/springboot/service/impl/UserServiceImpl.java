package com.shiyanlou.springboot.service.impl;

import com.shiyanlou.springboot.dao.BaseMapper;
import com.shiyanlou.springboot.entity.User;
import com.shiyanlou.springboot.service.IBaseService;
import com.shiyanlou.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  class UserServiceImpl extends BaseServiceImpl<User>  implements IUserService {

}
