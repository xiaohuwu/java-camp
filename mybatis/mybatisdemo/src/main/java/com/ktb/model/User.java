package com.ktb.model;
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


}
