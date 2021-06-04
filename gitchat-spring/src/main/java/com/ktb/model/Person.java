package com.ktb.model;


public class Person {
    private int id;
    private String name;
    private Car car4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar4() {
        return car4;
    }

    public void setCar4(Car car4) {
        this.car4 = car4;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car4=" + car4 +
                '}';
    }
}
