package com.ktb.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.springsecurity.entity.SysUser;
import com.ktb.springsecurity.mapper.SysUserMapper;
import com.ktb.springsecurity.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2022-11-15 16:27:48
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
