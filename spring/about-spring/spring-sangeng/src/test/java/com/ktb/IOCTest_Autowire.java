package com.ktb;

import com.ktb.juejin.autowired.BookDao;
import com.ktb.juejin.autowired.BookService;
import com.ktb.juejin.autowired.MainConfig;
import com.ktb.juejin.event.ExtConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowire {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(MainConfig.class);
        BookService bean = applicationContext.getBean(BookService.class);
        BookDao bookDao = bean.getBookDao();
        System.out.printf("book",bookDao);
    }

}
