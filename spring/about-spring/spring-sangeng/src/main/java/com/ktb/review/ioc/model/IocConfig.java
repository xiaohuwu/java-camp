package com.ktb.review.ioc.model;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@ComponentScan(value = "com.ktb.review", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
public class IocConfig {

    @Bean("Person")
    @Scope("prototype")
    public Person getPerson1() {
        return new Person();
    }


}
