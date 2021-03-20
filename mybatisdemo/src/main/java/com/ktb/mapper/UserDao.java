package com.ktb.mapper;

import com.ktb.model.User;

import java.util.List;

public interface UserDao {
 public List<User> findAllUsers();
}
