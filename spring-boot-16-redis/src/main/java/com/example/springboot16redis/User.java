package com.example.springboot16redis;


import lombok.experimental.Tolerate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "users")
public class User implements Serializable{


    private static final long serialVersionUID = 834663673051285150L;

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 5)
    private String name;
    private String email;
    private LocalDate birthday;

    @Tolerate
    public User() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthday);
    }
}
