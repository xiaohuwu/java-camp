package com.ktb.newbee.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.javers.core.metamodel.annotation.Id;

import java.util.Date;

/**
 * (TbNewbeeMallUser)表实体类
 *
 * @author makejava
 * @since 2022-10-31 14:30:30
 */
@SuppressWarnings("serial")
@Accessors(chain = true)
@TableName("tb_newbee_mall_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //用户主键id
    @Id
    @TableId("user_id")
    private Long userId;
    //用户昵称
    private String nickName;
    //登陆名称(默认为手机号)
    private String loginName;
    //MD5加密后的密码

    @JsonIgnore
    private String passwordMd5;
    //个性签名
    private String introduceSign;
    //注销标识字段(0-正常 1-已注销)
    @JsonIgnore
    private Integer isDeleted;
    //锁定标识字段(0-未锁定 1-已锁定)
    @JsonIgnore
    private Integer lockedFlag;
    //注册时间
    private Date createTime;


}

