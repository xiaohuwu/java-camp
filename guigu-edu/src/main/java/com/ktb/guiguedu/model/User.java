package com.ktb.guiguedu.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "users")
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
