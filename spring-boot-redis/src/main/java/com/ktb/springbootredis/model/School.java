package com.ktb.springbootredis.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "school_id")
    private List<Teacher> teacherList;

}
