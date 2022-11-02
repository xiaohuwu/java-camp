package com.example.springbootdruid;

import org.springframework.stereotype.Service;

@Service
public class DemoService2 {

    public int add(int a,int b){
        doBefore();
        return  a + b;
    }

    private void doBefore() {
        System.out.println(" DemoService2 -------- inner ----------: " + Thread.currentThread());
    }
}
