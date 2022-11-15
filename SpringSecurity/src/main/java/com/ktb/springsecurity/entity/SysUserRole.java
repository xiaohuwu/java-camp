package com.ktb.springsecurity.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (SysUserRole)表实体类
 *
 * @author makejava
 * @since 2022-11-15 22:28:07
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_role")
public class SysUserRole  {
    //用户id@TableId
    private Long userId;
    //角色id@TableId
    private Long roleId;




}

