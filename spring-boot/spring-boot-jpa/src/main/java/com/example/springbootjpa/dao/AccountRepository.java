package com.example.springbootjpa.dao;

import com.example.springbootjpa.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAllByUsernameLike(String str);
}
