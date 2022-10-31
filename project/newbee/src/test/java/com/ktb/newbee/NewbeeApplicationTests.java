package com.ktb.newbee;

import com.ktb.newbee.dao.UserDao;
import com.ktb.newbee.entity.Employee;
import com.ktb.newbee.entity.User;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.javers.core.diff.ListCompareAlgorithm.LEVENSHTEIN_DISTANCE;

@SpringBootTest
class NewbeeApplicationTests {

    @Autowired
    UserDao userDao;

    /**
     * 测试javers 能快速比较两个对象的差异
     */
    @Test
    void contextLoads() {
//		String md5Str = SecureUtil.md5("123456");
//		System.out.println(md5Str);
        User user = userDao.selectById(1);
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        user2.setNickName("xiaohuge123");

        Javers javers = JaversBuilder.javers().build();
        Diff diff = javers.compare(user, user2);
        System.out.println(javers.getJsonConverter().toJson(diff));

    }

    @Test
    public void  test1(){
        Javers javers = JaversBuilder.javers()
                .withListCompareAlgorithm(LEVENSHTEIN_DISTANCE)
                .build();

        Employee frodoOld = new Employee()
                .setName("Frodo")
                .setSalary(10000);

        Employee frodonew = new Employee()
                .setName("Frodo")
                .setSalary(2000);

        //when
        Diff diff = javers.compare(frodoOld, frodonew);
        System.out.println(diff.prettyPrint());
    }

}
