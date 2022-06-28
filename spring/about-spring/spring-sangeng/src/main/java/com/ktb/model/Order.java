package com.ktb.model;

public class Order {

    private String name;
    private String address;

    public Order(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public void initMethod(){
        System.out.println("initmethod");
    }



    public void destroyMethod() {
        System.out.println("第五步 执行销毁的方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
