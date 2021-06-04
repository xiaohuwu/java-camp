package com.ktb.model;

import org.springframework.stereotype.Component;


public class User {
    private int id;
    private String name;

    public User(int i, String name) {
         this.id = i;
         this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void add(){
        System.out.println("add......");
    }
}
