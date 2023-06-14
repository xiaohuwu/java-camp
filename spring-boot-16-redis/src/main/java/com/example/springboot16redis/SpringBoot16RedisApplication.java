package com.example.springboot16redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@EnableCaching
@SpringBootApplication
public class SpringBoot16RedisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot16RedisApplication.class, args);
        DataSource bean = run.getBean(DataSource.class);
        RequestMappingHandlerAdapter bean2 = run.getBean(RequestMappingHandlerAdapter.class);
        List<HttpMessageConverter<?>> messageConverters = bean2.getMessageConverters();
        messageConverters.forEach((item)->{
            System.out.println("item = " + item);
        });
        try {
            String url = bean.getConnection().getMetaData().getURL();
            RedisConnectionFactory bean1 = run.getBean(RedisConnectionFactory.class);
            System.out.println("bean1.getClass() = " + bean1.getClass());
            System.out.println("url = " + url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





    }

//    @Bean
//    public HttpMessageConverters converters() {
//        return new HttpMessageConverters(
//                false, Arrays.asList(new TheCustomConverter()));
//    }






    @EventListener
    public void handleEvent(Object event) {
        System.out.println("event: " + event);
    }

}
