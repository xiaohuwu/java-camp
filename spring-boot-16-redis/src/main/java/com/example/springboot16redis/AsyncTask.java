package com.example.springboot16redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncTask {

    @Async
    public void task() {
        String task = "task";
        log.info("task:{}", task);
    }
}
