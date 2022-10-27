package com.ktb.mybatisplus.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {
    MALE(0, "男"),
    FEMALE(1, "女");

    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(int i, String name) {
        this.sex = i;
        this.sexName = name;
    }

    @Override
    public String toString() {
        return sexName;
    }

}
