package com.ktb.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class UserEntity {
    private String name;
    private String address;

    public UserEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
