package com.ktb.sevice;

import com.ktb.dao.UserDao;
import com.ktb.model.MybatisUser;
import com.ktb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


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

    @Override
    public List getAllUser() {
        List<User> allUser = userDao.getAllUser();
        return allUser;
    }

    /**
     * 1、<tx:annotation-driven transaction-manager="transactionManager"/>
     * 2、 @Transactional 注解声明
     * @param user
     */
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
        int result = 1 / 0;
        User user1 = new User("ruowen", 12);
        userDao.addUser(user1);
    }


}
