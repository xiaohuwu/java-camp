import org.example.MainConfig;
import org.example.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainConfig.class})
public class SpringAnnotaionTest {

    @Autowired
    ApplicationContext applicationContext;


    @Test
    public void test1() {
        System.out.println("\"start\" = " + "start");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    public void test2() {
//        Person person1 = (Person) applicationContext.getBean("person");
//        Person person2 = (Person) applicationContext.getBean("person");
//        System.out.println("person1.equals(person2) = " + person1.equals(person2));

    }

}
