package com.ktb.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;


@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("depts")
public class Dept<T> extends BaseModel implements Serializable {
    private String name;
    @TableField(exist = false)
    private List<T> students;
}
