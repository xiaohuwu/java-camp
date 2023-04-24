package com.ktb.xuefeng.ioc;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(public * com.ktb.xuefeng.service.UserService.*(..))")
    public void doAccessCheck() {
       log.info("[Before] do access check...");
    }
}
