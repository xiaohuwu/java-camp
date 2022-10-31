package com.ktb.newbee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ktb.newbee.config.Result;
import com.ktb.newbee.entity.param.LoginParam;
import com.ktb.newbee.entity.User;

/**
 * (TbNewbeeMallUser)表服务接口
 *
 * @author makejava
 * @since 2022-10-31 14:30:32
 */
public interface UserService extends IService<User> {

    Result<Object> login(LoginParam param);

}

