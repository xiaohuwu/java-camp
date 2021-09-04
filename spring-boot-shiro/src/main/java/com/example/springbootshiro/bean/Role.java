package com.example.springbootshiro.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Role {
    private String id;
    private String roleName;

    private Set<Permissions> permissions;
}
