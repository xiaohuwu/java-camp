package com.ktb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Test.class.getResourceAsStream("/mybatis/SqlMapConfig.xml");
        System.out.println("resourceAsStream.available() = " + resourceAsStream.available());

        List<String> strings = Arrays.asList("a", "b", "c");
        String[] target = new String[strings.size()];
        System.out.println("strings.toArray(target) = " + strings.toArray(target));
        
    }
}
