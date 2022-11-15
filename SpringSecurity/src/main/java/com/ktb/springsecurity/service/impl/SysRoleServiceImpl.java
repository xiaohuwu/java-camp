package com.ktb.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.springsecurity.entity.SysRole;
import com.ktb.springsecurity.mapper.SysRoleMapper;
import com.ktb.springsecurity.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2022-11-15 22:28:06
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

}
