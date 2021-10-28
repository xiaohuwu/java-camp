import com.ktb.dao.UserDao;
import com.ktb.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:application.xml"})
public class DaoTest {
    @Autowired
    UserDao userDao;


    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD(){
	 	//1、创建SpringIOC容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
//		//2、从容器中获取mapper
//        UserDao bean = ioc.getBean(UserDao.class);
//        System.out.println(bean);

        User user = new User();
        user.setUsername("哥哥");
        userDao.insert(user);
    }

}
