package com.ktb.model;

public class MyStudent implements Comparable{

    Long age;

    public MyStudent(Long age) {
        this.age = age;
    }

    public MyStudent() {
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return o.hashCode();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
