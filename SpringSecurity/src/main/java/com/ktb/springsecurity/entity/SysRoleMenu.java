package com.ktb.springsecurity.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (SysRoleMenu)表实体类
 *
 * @author makejava
 * @since 2022-11-15 22:28:07
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_menu")
public class SysRoleMenu  {
    //角色ID@TableId
    private Long roleId;
    //菜单id@TableId
    private Long menuId;




}

