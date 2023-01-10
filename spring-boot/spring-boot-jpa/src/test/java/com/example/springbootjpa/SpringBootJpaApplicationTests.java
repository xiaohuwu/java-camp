package com.example.springbootjpa;

import com.example.springbootjpa.dao.AccountRepository;
import com.example.springbootjpa.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBootJpaApplicationTests {
    @Resource
    AccountRepository repository;

    @Transactional
    @Test
    void contextLoads() {
        //直接根据ID查找
        repository.findById(1).ifPresent((account) -> {
            System.out.println(account.getUsername());
            System.out.println(account.getAccountDetail());
        });
    }

    @Test
    void addAccount() {
        Account account = new Account();
        account.setUsername("Admin");
        account.setPassword("123456");
        account = repository.save(account);  //返回的结果会包含自动生成的主键值
        System.out.println("插入时，自动生成的主键ID为：" + account.getId());
    }

    @Test
    void queryAccount() {
        List<Account> account = repository.findAllByUsernameLike("%Admin%");
        account.forEach(System.out::println);
    }


}
