package com.example.springboot16redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@EnableCaching
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringBoot16RedisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot16RedisApplication.class, args);
        DataSource bean = run.getBean(DataSource.class);
        RequestMappingHandlerAdapter bean2 = run.getBean(RequestMappingHandlerAdapter.class);
        List<HttpMessageConverter<?>> messageConverters = bean2.getMessageConverters();
        messageConverters.forEach((item) -> {
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

//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        lc.addTurboFilter(new MyTurboFilter());


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
