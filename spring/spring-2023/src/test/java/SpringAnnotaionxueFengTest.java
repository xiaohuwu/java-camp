import com.ktb.xuefeng.ioc.AppConfig;
import com.ktb.xuefeng.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SpringAnnotaionxueFengTest {

    @Autowired
    ApplicationContext applicationContext;




    /**
     * 属性条件注解测试
     */
    @Test
    public void test3() {
        MailService bean = applicationContext.getBean(MailService.class);
        System.out.println("bean = " + bean);
    }

}
