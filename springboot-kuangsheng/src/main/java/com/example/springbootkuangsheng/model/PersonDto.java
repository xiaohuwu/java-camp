package com.example.springbootkuangsheng.model;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;


public class PersonDto {

    @NotBlank
    private String name;

    @Email(message = "邮箱格式有误")
    private String email;

    @Max(value = 90, message = "年龄最大不超过90")
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}