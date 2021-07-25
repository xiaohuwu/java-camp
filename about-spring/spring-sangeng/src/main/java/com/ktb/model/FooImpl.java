package com.ktb.model;

import org.springframework.stereotype.Service;

@Service
public class FooImpl implements Foo {

    @Override
    public void foo() {
        System.out.println("foo");
    }

    public void bar() {
        System.out.println("bar");
    }
}
