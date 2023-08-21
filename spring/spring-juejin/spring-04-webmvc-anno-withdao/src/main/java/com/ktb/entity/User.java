package com.ktb.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class User {

    private String id;


    @NotBlank(message = "{user.username.notblank}")
    @Length(min = 6, max = 20, message = "{user.username.length}")
    private String username;


    private String name;

    private Date birthday;

    private byte[] photo;


    private Department department;
}
