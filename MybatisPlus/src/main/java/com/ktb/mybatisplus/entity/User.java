package com.ktb.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author atguigu
 * @since 2022-10-27
 */
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
@Accessors(chain = true)
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long uid;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("邮箱")
    private String email;

    private Integer isDelete;

    private Integer sex;


    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", name=" + name + ", age=" + age + ", email=" + email + ", isDelete=" + isDelete + ", sex=" + sex + "}";
    }
}
