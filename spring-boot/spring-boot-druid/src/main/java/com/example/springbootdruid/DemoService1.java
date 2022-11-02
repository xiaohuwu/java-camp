package com.example.springbootdruid;

import org.springframework.stereotype.Service;

@Service
public class DemoService1 {

    public int add(int a,int b){
        doBefore();
        return  a + b;
    }

    private void doBefore() {
        System.out.println(" DemoService1 -------- inner ----------: " + Thread.currentThread());
    }
}
