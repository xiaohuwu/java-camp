package com.ktb;

import com.ktb.dao.UserServiceImpl;
import com.ktb.service.PhoneService;
import com.ktb.service.UserService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //创建容器
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String item: beanDefinitionNames) {
            System.out.println(item);
        }
        //获取对象
        PhoneService userDao = (PhoneService) app.getBean("phoneService");
        userDao.deleteAll();
    }
}
