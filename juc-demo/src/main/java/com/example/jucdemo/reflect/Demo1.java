package com.example.jucdemo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Class studentClass = Student.class;
//        Field score = studentClass.getField("score");
//        String name = score.getName();
//        Class<?> type = score.getType();
//        System.out.println("name = " + name);
//        System.out.println("type = " + type);

//
//        System.out.println("score = " + score);
//        Field grade = studentClass.getDeclaredField("grade");
//        System.out.println("grade = " + grade);


//        Object p = new Person("Xiao Ming");
//        Class<?> aClass = p.getClass();
//        Field name1 = aClass.getField("name");
//        Object o = name1.get(p);
//        System.out.println("o = " + o);

//        Student p = new Student("gege");
//        p.setGrade(1);
//        Class aClass = p.getClass();
//        Field grade = aClass.getDeclaredField("grade");
//        grade.setAccessible(true);
//        Object o = grade.get(p);
//        System.out.println("o = " + o);


        Student student = new Student("gegteg");
        student.setScore(20);
        Class<? extends Student> aClass = student.getClass();
        Method getGrade = aClass.getMethod("getScore");
        Object invoke = getGrade.invoke(student);
        System.out.println("invoke = " + invoke);



    }


}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person {
    public int score;
    private int grade;

    public Student(String name) {
        super(name);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
