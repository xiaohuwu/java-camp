package com.ktb.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktb.springsecurity.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 菜单表(SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-15 22:28:07
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenues(@Param("roles") List<Long> roles);
}
