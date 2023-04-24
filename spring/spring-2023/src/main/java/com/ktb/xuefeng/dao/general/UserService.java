package com.ktb.xuefeng.dao.general;

import com.ktb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("mybatisService")
@Transactional
public class UserService extends AbstractDao<User> {

    @Autowired
    UserDao userDao;


    public UserService() {
        super();
    }

    public User getUserById(Integer id){
        User byId = userDao.getById(id);
        return byId;
    }

}
