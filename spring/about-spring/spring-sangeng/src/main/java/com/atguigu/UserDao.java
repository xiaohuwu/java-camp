package com.atguigu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void print(){
        System.out.println("this  is user dao");
    }
}
