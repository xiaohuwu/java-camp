package com.ktb.springbootredis.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


//@Data
//@Entity
//public class Teacher {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String name;
//
//
//    @ManyToOne
//    private School school;
//
//
//    @JsonIgnore
//    @ManyToMany(fetch=FetchType.LAZY)
//    /**
//     * Description:
//     * 1、关系两边都作为主控；
//     * 2、joinColumns中@JoinColumn(name="t_id") 其中t_id为JoinTable 中的外键，由于 Student 和Teacher 的主键都为id 这边就省略referencedColumnName="id"。
//     */
//    @JoinTable(name="teacher_student",joinColumns={@JoinColumn(name="t_id")},inverseJoinColumns={@JoinColumn(name="s_id")})
//    private Set<Student> students;
//
//}
