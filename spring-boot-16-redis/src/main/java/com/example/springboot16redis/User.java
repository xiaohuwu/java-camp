package com.example.springboot16redis;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "users")
@Entity
@Data
@Builder
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
}
