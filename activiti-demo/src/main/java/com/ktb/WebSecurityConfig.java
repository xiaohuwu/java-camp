package com.ktb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // 在内存中创建用户"zhangsan01"，设置密码和权限
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("zhangsan01")
                        .password("password")
                        .roles("USER")
                        .build();

        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("zhangsan02")
                        .password("password")
                        .roles("USER")
                        .build();

        // 使用InMemoryUserDetailsManager
        return new InMemoryUserDetailsManager(user,user1);
    }
}
