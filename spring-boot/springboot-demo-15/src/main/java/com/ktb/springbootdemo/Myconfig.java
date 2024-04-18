package com.ktb.springbootdemo;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//@Configuration
//@PropertySource("classpath:jdbc.properties")
public class Myconfig {

    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;


    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

//    @Bean
//    @Primary
//    public DataSource otherDataSource(Otherconfig otherconfig ){
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        hikariDataSource.setJdbcUrl(otherconfig.getUrl());
//        hikariDataSource.setUsername(otherconfig.getUsername());
//        hikariDataSource.setDriverClassName(otherconfig.getDriverClassName());
//        return hikariDataSource;
//    }

    @Bean
    @ConfigurationProperties(value="spring.datasource")
    public DataSource otherDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }

}
