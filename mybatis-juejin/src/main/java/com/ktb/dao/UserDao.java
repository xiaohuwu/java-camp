package com.ktb.dao;

import com.ktb.entity.Department;
import com.ktb.entity.User;

import java.util.List;


public interface UserDao {

    List<User> findAll();

    List<User> findAllByLazy();
//    User findById(String id);
//    int  save(User department);
//    int  update(User department);
//    int  deleteById(String id);

}
