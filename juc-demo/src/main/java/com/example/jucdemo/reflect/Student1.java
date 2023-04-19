package com.example.jucdemo.reflect;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Student1 extends Person1 {

    public Student1(String name, String city) {
        super(name, city);
    }

    public static void main(String[] args) {
        Annotation[] annotations = Student1.class.getAnnotations();
        System.out.println("annotations = " + Arrays.toString(annotations));
        Report annotation = Student1.class.getAnnotation(Report.class);
//        int type = annotation.type();
//        System.out.println("type = " + type);
    }
}
