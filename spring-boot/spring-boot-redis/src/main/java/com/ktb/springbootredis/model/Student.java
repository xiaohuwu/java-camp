package com.ktb.springbootredis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String name;
//
//    @Column(columnDefinition = "enum('male','female')")
//    private String sex;
//
//    @OneToOne(cascade = {CascadeType.REMOVE})
//    @JoinColumn(name = "card_id")
//    private Card card;
//
//    @JsonIgnore
//    @ManyToMany(fetch=FetchType.LAZY)
//    @JoinTable(name="teacher_student",joinColumns={@JoinColumn(name="s_id")},inverseJoinColumns={@JoinColumn(name="t_id")})
//    private Set<Teacher> teachers;
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public Card getCard() {
//        return card;
//    }
//
//    public void setCard(Card card) {
//        this.card = card;
//    }
//
//    public Set<Teacher> getTeachers() {
//        return teachers;
//    }
//
//    public void setTeachers(Set<Teacher> teachers) {
//        this.teachers = teachers;
//    }
//}
