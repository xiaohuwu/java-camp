import org.example.MainConfig;
import org.example.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Arrays;
import java.util.Map;


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

    /**
     * Conditional 条件注解
     */
    @Test
    public void test2() {
        System.out.println("\"start\" = " + "start");
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class); // 找到这个Person类型的所有bean
        System.out.println("=========" + persons);
    }

}
