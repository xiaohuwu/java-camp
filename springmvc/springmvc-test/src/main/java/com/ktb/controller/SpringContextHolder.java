package com.ktb.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String item: beanDefinitionNames) {
            System.out.println("============>"+item);
        }
//        //获取对象
//        MappingJackson2HttpMessageConverter messageConverter = (MappingJackson2HttpMessageConverter) applicationContext.getBean("getMappingJackson2HttpMessageConverter");
//        DateFormat dateFormat = messageConverter.getObjectMapper().getDateFormat();
//        System.out.println("dateFormat:"+dateFormat);
    }
}
