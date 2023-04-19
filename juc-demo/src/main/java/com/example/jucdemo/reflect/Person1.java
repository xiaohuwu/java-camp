package com.example.jucdemo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Report(type = 1)
public class Person1 {

    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;


    public Person1(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person1 person1 = new Person1("66", "citycitycitycitycitycitycitycitycity");

        Field[] fields = person1.getClass().getFields();
        for (Field field : fields) {
            Range annotation = field.getAnnotation(Range.class);
            int min = annotation.min();
            int max = annotation.max();
            String name = field.getName();
            Object o = field.get(person1);
            Method method = person1.getClass().getMethod("get" + capitalizeFirstLetter(name));
            String invoke = (String) method.invoke(person1);
            if (invoke.length() < min || invoke.length() > max) {
                throw new IllegalAccessException(name + "参数异常");
            }
        }
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
