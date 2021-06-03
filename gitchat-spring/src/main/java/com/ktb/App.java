package com.ktb;

import com.ktb.model.Car;
import com.ktb.model.Student;
import com.ktb.model.User;
import com.ktb.model.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //1.加载 spring 配置文件,根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.得到配置创建的对象
        Student user = (Student) context.getBean("stu");
        Student user2 = (Student) context.getBean("stu");
        Car car = (Car) context.getBean("car12");
        System.out.println("car:"+car);

        ComboPooledDataSource dataSource = (ComboPooledDataSource) context.getBean("dataSource");
        System.out.println(dataSource);


//        user.add();
//        Student stu = (Student) context.getBean(Student.class);
        System.out.println(user == user2);

        Student stu4 = (Student) context.getBean("stu4");
        System.out.println(stu4);


    }
}
