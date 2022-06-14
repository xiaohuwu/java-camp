package com.sangeng.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    private Integer id;
    private String name;
    private Integer age;
    private String[] likes;



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", likes=").append(likes == null ? "null" : Arrays.asList(likes).toString());
        sb.append('}');
        return sb.toString();
    }
}
