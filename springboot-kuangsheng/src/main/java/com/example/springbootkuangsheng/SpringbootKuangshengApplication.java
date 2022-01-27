package com.example.springbootkuangsheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class SpringbootKuangshengApplication {

    public static void main(String[] args) {

//        try {
//            InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("com/wisdom/HelloService  AutoConfiguration.class");
//            int length = systemResourceAsStream.available();
//            System.out.println("length = " + length);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        SpringApplication.run(SpringbootKuangshengApplication.class, args);
    }



//    @Bean
//    public ServletRegistrationBean dispatcherRegistration() {
//        return new ServletRegistrationBean(dispatcherServlet());
//    }
//
//    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
//    public DispatcherServlet dispatcherServlet() {
//        return new LoggableDispatcherServlet();
//    }

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
                = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }

}
