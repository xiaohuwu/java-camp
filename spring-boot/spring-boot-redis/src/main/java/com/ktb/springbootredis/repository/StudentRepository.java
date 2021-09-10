package com.ktb.springbootredis.repository;


import com.ktb.springbootredis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository  extends JpaRepository<Student,Integer> {

    Student findById(int id);

}
