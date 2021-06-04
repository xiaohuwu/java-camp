package com.ktb;

import com.ktb.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {

    private static Map<Integer,User> users;

    static{
        users = new HashMap<Integer,User>();
        users.put(1, new User(1, "张三"));
        users.put(2, new User(2, "李四"));
        users.put(3, new User(3, "王五"));
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }
}
