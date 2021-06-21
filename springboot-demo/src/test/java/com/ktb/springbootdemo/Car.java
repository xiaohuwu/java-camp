package com.ktb.springbootdemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Car {

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public  void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    @Test
    public void test1(){
        Car car = Car.create(Car::new);
        final List< Car > cars = Arrays.asList( car );
        cars.forEach(System.out::println);

        cars.forEach( Car::repair );
    }

    @Test
    public void test2(){
//        Car car = Car.create(Car::new);
//        final List< Car > cars = Arrays.asList( car );
//        cars.forEach(car::repair);
    }

    @Test
    public void test3(){

        final Car police = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( police );
        cars.forEach(police::follow );

        Supplier<List<String>> supplier = ArrayList<String>::new;
        List<String> strings = supplier.get();

        List<Integer> features = Arrays.asList(1,2);
        Consumer<Integer> consumer = n -> System.out.println(n);
        features.forEach(consumer);
    }




}
