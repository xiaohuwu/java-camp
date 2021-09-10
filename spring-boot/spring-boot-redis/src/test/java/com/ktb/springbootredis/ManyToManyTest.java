package com.ktb.springbootredis;

import com.ktb.springbootredis.model.School;
import com.ktb.springbootredis.model.Student;
import com.ktb.springbootredis.model.Teacher;
import com.ktb.springbootredis.repository.SchoolRepository;
import com.ktb.springbootredis.repository.StudentRepository;
import com.ktb.springbootredis.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManyToManyTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void add() {
        Set<Teacher> teachers = new HashSet<>();
        Set<Student> students = new HashSet<>();

        Student student1 = new Student();
        student1.setName("zhonghua");
        students.add(student1);
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("zhiran");
        students.add(student2);
        studentRepository.save(student2);

        Teacher teacher1 = new Teacher();
        teacher1.setName("龙老师");
        teacher1.setStudents(students);
        teacherRepository.save(teacher1);
    }

    @Test
    public void get() {
        Teacher nameContaining = teacherRepository.findByNameContaining("龙老师");
        Set<Student> students = nameContaining.getStudents();
        students.forEach(student -> System.out.println(student));
    }


}
