package com.ktb;
import com.ktb.dao.AlphaDao;
import com.ktb.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(MainApplication.class)
public class TestApplication implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void getConfig(){
        SimpleDateFormat bean = applicationContext.getBean(SimpleDateFormat.class);
        System.out.printf("SimpleDateFormat====>"+bean);
    }

    @Test
    public void getDao(){
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());

        alphaDao = applicationContext.getBean("alphDaoHibernateDao", AlphaDao.class);
        System.out.println(alphaDao.select());
    }

    @Resource
    @Qualifier("alphDaoHibernateDao")
    AlphaDao alphaDao;


    @Autowired
    private AlphaService alphaService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;


    @Test
    public void testDI() {
        String select = alphaDao.select();
        System.out.println("select:==>"+ select);
        System.out.println(alphaService);
        System.out.println(simpleDateFormat);
    }



}
