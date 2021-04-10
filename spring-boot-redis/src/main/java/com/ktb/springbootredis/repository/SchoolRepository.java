package com.ktb.springbootredis.repository;


import com.ktb.springbootredis.model.Card;
import com.ktb.springbootredis.model.School;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SchoolRepository extends JpaRepository<School,Integer> {

    School findById(int id);

}
