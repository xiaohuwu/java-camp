package com.ktb.springsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ktb.springsecurity.entity.LoginUser;
import com.ktb.springsecurity.entity.SysMenu;
import com.ktb.springsecurity.entity.SysUserRole;
import com.ktb.springsecurity.entity.User;
import com.ktb.springsecurity.mapper.SysMenuMapper;
import com.ktb.springsecurity.mapper.SysUserMapper;
import com.ktb.springsecurity.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, s);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<SysUserRole>();
        wrapper.eq(SysUserRole::getUserId, user.getId());
        List<Long> collect = userRoleMapper.selectList(wrapper).stream().map(sysUserRole -> sysUserRole.getUserId()).collect(Collectors.toList());

        List<SysMenu> menues = menuMapper.getMenues(collect);
        List<String> collect1 = menues.stream().map(SysMenu::getMenuName).collect(Collectors.toList());
        return  new LoginUser(user,collect1);
    }
}
