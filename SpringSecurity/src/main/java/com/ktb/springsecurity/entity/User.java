package com.ktb.springsecurity.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户表(SysUser)表实体类
 *
 * @author makejava
 * @since 2022-11-15 16:27:42
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User {
    //主键@TableId
    private Long id;

    //用户名
    private String userName;
    //昵称
    private String nickName;
    //密码
    private String password;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //头像
    private String avatar;
    //用户类型（0管理员，1普通用户）
    private String userType;
    //创建人的用户id
    private Long createBy;
    //创建时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //更新人
    private Long updateBy;
    //更新时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;





}

