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
    private String password;

    private List<Role> roles;

<<<<<<< HEAD
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
=======



    public User() {
>>>>>>> origin/master
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
