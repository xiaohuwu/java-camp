package com.ktb.java8;

import com.ktb.java8.model.Student;

import java.util.ArrayList;
import java.util.List;

public class FunctionDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList();
        list.add(new Student("Ram", 20));
        list.add(new Student("Shyam", 22));
        list.add(new Student("Kabir", 18));
        for (Student st : list) {
            String s = st.customShow((Student student) -> {
                return student.toString();
            });
            System.out.println("s = " + s);
        }
    }
}
