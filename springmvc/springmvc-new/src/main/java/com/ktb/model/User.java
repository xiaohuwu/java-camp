package com.ktb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class User {

    private String name;
    private Integer age;

    public User() {

    }

    public User(String name, Integer age) {

        this.name = name;
        this.age = age;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date birthday;



    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
