package com.ktb.sevice;

import com.ktb.dao.UserDao;
import com.ktb.model.MybatisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;

    @Override
    public List<MybatisUser> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public MybatisUser getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public void saveUser(MybatisUser user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(MybatisUser user) {
         userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
