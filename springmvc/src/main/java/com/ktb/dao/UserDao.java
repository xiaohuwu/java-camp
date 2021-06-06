package com.ktb.dao;

import com.ktb.model.MybatisUser;
import com.ktb.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface UserDao {
    List<MybatisUser> listAllUsers();

    MybatisUser getUser(Integer id);

    void saveUser(MybatisUser user);

    void updateUser(MybatisUser user);

    void deleteUser(Integer id);

    List<User> getAllUser();

    void addUser(User user);
}
