package com.example.springbootkuangsheng;

import com.example.springbootkuangsheng.dao.CityMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@MapperScan("com.example.springbootkuangsheng.dao")
public class SpringbootKuangshengApplication implements CommandLineRunner {

    CityMapper cityMapper;


    public SpringbootKuangshengApplication(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public static void main(String[] args) {


        ConfigurableApplicationContext run = SpringApplication.run(SpringbootKuangshengApplication.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

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

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findByState("xiaohu").toString());
    }


}
