package com.ktb.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktb.common.entity.system.SystemUser;

public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}
