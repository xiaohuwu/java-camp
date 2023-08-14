package org.example.basic_di.c_value_spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Green {



    @Value("#{blue.name.substring(0,3)}")
    private String name;

    @Value("#{2 + blue.order }")
    private Integer order;


    @Override
    public String toString() {
        return "Green{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
