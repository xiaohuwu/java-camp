package com.ktb.springbootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

    @Async
    public void asyncSay() {
       log.info(Thread.currentThread().getName() +"我看看我是不是异步的");
    }
}
