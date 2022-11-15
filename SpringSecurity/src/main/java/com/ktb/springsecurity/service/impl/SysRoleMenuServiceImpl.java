package com.ktb.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.springsecurity.entity.SysRoleMenu;
import com.ktb.springsecurity.mapper.SysRoleMenuMapper;
import com.ktb.springsecurity.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * (SysRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2022-11-15 22:28:07
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

}
