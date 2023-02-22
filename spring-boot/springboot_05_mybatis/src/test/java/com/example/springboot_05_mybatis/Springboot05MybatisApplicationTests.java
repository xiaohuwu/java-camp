package com.example.springboot_05_mybatis;

import com.example.springboot_05_mybatis.dao.BookDao;
import com.example.springboot_05_mybatis.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    BookDao bookDao;

    @Test
    void contextLoads() {
        Book byId = bookDao.selectById(1);
        System.out.println("byId = " + byId);
    }

}
