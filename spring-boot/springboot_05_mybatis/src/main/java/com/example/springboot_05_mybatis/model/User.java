package com.example.springboot_05_mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;

    @TableField("address")
    private String addressStr;

}
