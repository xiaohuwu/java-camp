package com.ktb.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

@Component
public class MyBean implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        try {
            RequestMappingHandlerAdapter bean = applicationContext.getBean(RequestMappingHandlerAdapter.class);
            if (bean != null) {
                List<HttpMessageConverter<?>> messageConverters = bean.getMessageConverters();
                for (HttpMessageConverter<?> messageConverter : messageConverters) {
                    System.out.println("messageConverter = " + messageConverter);
                }
            }
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                System.out.println("beanDefinitionName = " + beanDefinitionName);
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
