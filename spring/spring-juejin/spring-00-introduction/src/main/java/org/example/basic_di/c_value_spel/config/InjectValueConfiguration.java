package org.example.basic_di.c_value_spel.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// 顺便加上包扫描
@ComponentScan("org.example.basic_di.c_value_spel")
@PropertySource("classpath:red.properties")
public class InjectValueConfiguration {

}
