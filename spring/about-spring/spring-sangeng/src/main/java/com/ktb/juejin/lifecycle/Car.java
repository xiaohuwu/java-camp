package com.ktb.juejin.lifecycle;
import javax.annotation.PostConstruct;

public class Car {

    public void init(){
        System.out.println("init======>");
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("start");
    }


    public void end(){
        System.out.println("start");
    }


    public void destroy(){
        System.out.println("destroy");
    }
}
