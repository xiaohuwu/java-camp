package com.example.springbootdruid;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @AutoInject
    DemoService1 demoService1;

    public int add(int a, int b) {
        return demoService1.add(a, b);
    }
}
