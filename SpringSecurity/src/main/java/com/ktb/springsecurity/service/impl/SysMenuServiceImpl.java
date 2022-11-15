package com.ktb.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.springsecurity.entity.SysMenu;
import com.ktb.springsecurity.mapper.SysMenuMapper;
import com.ktb.springsecurity.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单表(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2022-11-15 22:28:07
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
