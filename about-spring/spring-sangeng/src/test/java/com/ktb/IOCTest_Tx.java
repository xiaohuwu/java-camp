package com.ktb;
import com.ktb.juejin.property.MainConfig;
import com.ktb.juejin.tx.TxConfig;
import com.ktb.juejin.tx.UserService;
import com.ktb.model.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();

    }

}
