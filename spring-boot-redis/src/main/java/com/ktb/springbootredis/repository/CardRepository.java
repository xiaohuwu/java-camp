package com.ktb.springbootredis.repository;


import com.ktb.springbootredis.model.Card;
import com.ktb.springbootredis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRepository extends JpaRepository<Card,Long> {

    Card findById(int id);

}
