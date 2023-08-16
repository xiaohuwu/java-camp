package com.ktb.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String id;

    private String username;

    private String name;

    private Date birthday;

    private byte[] photo;

    private Department department;
}
