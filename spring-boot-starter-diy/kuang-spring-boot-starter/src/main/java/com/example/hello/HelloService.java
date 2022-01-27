package com.example.hello;

public class HelloService {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 家乡
     */
    private String hometown;

    public HelloService(String name, Integer age, String hometown) {
        this.name = name;
        this.age = age;
        this.hometown = hometown;
    }

    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String helloWorld() {
        return String.format("[name=%s, age=%d, hometown=%s]", this.name, this.age, this.hometown);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
