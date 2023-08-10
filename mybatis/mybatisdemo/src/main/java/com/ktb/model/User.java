package com.ktb.model;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private Department department;


    private String username;
    private String address;
    private String password;

    private List<Role> roles;


}
