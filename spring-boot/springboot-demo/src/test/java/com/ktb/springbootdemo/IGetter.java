package com.ktb.springbootdemo;


import java.io.Serializable;

@FunctionalInterface
public interface IGetter<T> extends Serializable {
    Object good(T source);
}
