package com.atguigu;

 interface Fruit {
    int eat();
}


public class Apple implements Fruit {
    @Override
    public int eat() {
        return 5;
    }
}

