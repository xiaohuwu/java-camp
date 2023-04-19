package com.example.jucdemo.reflect;

import java.lang.annotation.*;

@Target({ElementType.TYPE,
        ElementType.FIELD
    })
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}



