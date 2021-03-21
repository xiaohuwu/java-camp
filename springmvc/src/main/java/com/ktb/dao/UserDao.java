package com.ktb.dao;

import com.ktb.model.MybatisUser;
import java.util.List;



public interface UserDao {
    List<MybatisUser> listAllUsers();

    MybatisUser getUser(Integer id);

    void saveUser(MybatisUser user);

    void updateUser(MybatisUser user);

    void deleteUser(Integer id);
}
