package com.ktb.controller;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApplicationContext context;

        @RequestMapping("/hello")
        public String hello() {

            Map<String, ContentNegotiationStrategy> map =
                    BeanFactoryUtils.beansOfTypeIncludingAncestors(
                            context, ContentNegotiationStrategy.class,
                            true, false);

            map.forEach((k, v) -> System.out.printf("%s=%s%n",
                    k, v.getClass().getSimpleName()));


            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            Stream.of(beanDefinitionNames).forEach(System.out::println);
            return "response";
        }
}
