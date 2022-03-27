package com.ktb.febsserversystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ktb.common.entity.system.UserRole;

public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}
