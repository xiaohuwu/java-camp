package com.ktb.mapper;

import com.ktb.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
 public List<User> findAllUsers();

 public List<User> findAll();

 List<User> findById(Integer id);

 User findUser(User user);

 User findbyCondition(@Param("username") String  username, @Param("age") int age);

 User findbyConditionTwo(@Param("username") String  username, @Param("age") Integer age);

 void insertUser(User user);
 void deleteById(Integer id);
 void updateUser(User user);

 List<User> findbyConditionThree();

}
