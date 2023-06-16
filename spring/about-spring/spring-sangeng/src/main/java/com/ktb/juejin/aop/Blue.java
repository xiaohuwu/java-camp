package com.ktb.juejin.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Blue {

    @Value("${jdbc.url}")
    private String url;

    public Blue() {
        System.out.println("Blue created");
    }

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("Blue 监听到事件:" + event);
    }


    @Autowired
    MathCalculator mathCalculator;

}
