package com.ktb.springbootredis;

import com.ktb.springbootredis.model.Card;
import com.ktb.springbootredis.model.Student;
import com.ktb.springbootredis.repository.CardRepository;
import com.ktb.springbootredis.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    CardRepository cardRepository;

    @Resource
    StudentRepository studentRepository;

    @Test
    void  testOneToOne(){
        Student student1 = new Student();
        student1.setName("赵大伟");
        student1.setSex("male");
        Student student2 = new Student();
        student2.setName("赵大宝");
        student2.setSex("male");

        Card card1 = new Card();
        card1.setNum(422802);
        student1.setCard(card1);
        studentRepository.save(student1);
        studentRepository.save(student2);
        Card card2 = new Card();
        card2.setNum(422803);
        cardRepository.save(card2);
        /**
         * Description: 获取添加之后的id
         */
        int id = student1.getId();
        /**
         * Description: 删除刚刚添加的student1
         */
        studentRepository.deleteById(id);
    }

    @Test
    void  testOneToOneGet(){
        Student byId = studentRepository.findById(1);
        Card card = byId.getCard();
        System.out.println("card:"+card);
    }


}
