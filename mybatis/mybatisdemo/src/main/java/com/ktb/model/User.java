package com.ktb.model;


import lombok.Builder;
import lombok.Data;


@Data
public class User {
    private Integer id;

    private String username;

    private Integer age;

    private String address;


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
