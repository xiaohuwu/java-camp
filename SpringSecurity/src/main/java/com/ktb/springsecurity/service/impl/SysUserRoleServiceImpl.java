package com.ktb.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.springsecurity.entity.SysUserRole;
import com.ktb.springsecurity.mapper.SysUserRoleMapper;
import com.ktb.springsecurity.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * (SysUserRole)表服务实现类
 *
 * @author makejava
 * @since 2022-11-15 22:28:07
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}
