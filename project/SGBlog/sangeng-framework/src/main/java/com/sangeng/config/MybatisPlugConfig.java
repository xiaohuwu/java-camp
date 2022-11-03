package com.sangeng.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlugConfig implements SmartInitializingSingleton {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void afterSingletonsInstantiated() {
        sqlSessionFactory.getConfiguration().addInterceptor(new SqlInterceptor());
    }
}
