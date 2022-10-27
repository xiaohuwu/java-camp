package com.ktb.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
public class User {
    private Integer id;

    private String username;

    private Integer age;

    private String address;

    private List<Role> roles;




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
