package com.ktb.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("students")
public class Student extends BaseModel {
    private Integer id;
    private String name;
    private Integer deptId;
}
