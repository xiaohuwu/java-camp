package com.ktb.springbootredis.repository;


import com.ktb.springbootredis.model.Card;
import com.ktb.springbootredis.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findById(int id);
    Teacher findByNameContaining(String  name);

}
