package com.example.springboot16redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Component
@Slf4j
public class RefreshListener {
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    private AsyncTask task;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {

        handlerAdapter.getMessageConverters()
                .stream()
                .forEach(System.out::println);
    }

    @Scheduled(fixedDelay = 1000)
    public void doSomething() {
        log.info("start:{}", "start");
        task.task();
    }

    @Async
    void task(String s) {
        log.info(s);
    }

}
