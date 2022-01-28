package com.example.springbootkuangsheng.model;

import java.beans.Transient;
import java.util.Date;

public class Employees {
    private Long id;

    private String lastname;

    private String email;

    private Integer gender;

    private Integer department;

    private Date birth;

    private Date createdAt;

    private Date updatedAt;


    private Departments eDepartment;


    public Departments geteDepartment() {
        return eDepartment;
    }

    public void seteDepartment(Departments eDepartment) {
        this.eDepartment = eDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", birth=" + birth +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", eDepartment=" + eDepartment +
                '}';
    }
}