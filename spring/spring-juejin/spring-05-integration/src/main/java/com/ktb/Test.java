package com.ktb;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Test.class.getResourceAsStream("/mybatis/SqlMapConfig.xml");
        System.out.println("resourceAsStream.available() = " + resourceAsStream.available());
    }
}
