package com.ktb.guiguedu.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;


@EqualsAndHashCode()
@Data
@Accessors(chain = true)
@AllArgsConstructor
@TableName(value = "users")
@NoArgsConstructor
public class User extends Model<User> {

    @TableId(type=IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String operator;

    @TableField(value="create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;



    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
