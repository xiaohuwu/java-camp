package com.ktb.config;

import com.ktb.juejin.autowired.BookService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//@ComponentScans(
//        value = {
//                @ComponentScan(value="com.ktb",includeFilters = {
//					@ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
//						@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),
//                        @ComponentScan.Filter(type= FilterType.CUSTOM,classes={MyTypeFilter.class}
//                        )
//                },useDefaultFilters = false)
//        }
//)
@ComponentScan("com.ktb")
public class MainConfig {

}
