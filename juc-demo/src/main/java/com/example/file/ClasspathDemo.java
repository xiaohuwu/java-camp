package com.example.file;

import java.io.IOException;
import java.io.InputStream;

public class ClasspathDemo {
    public static void main(String[] args) {
        try (InputStream input = ClasspathDemo.class.getResourceAsStream("/application.properties")) {
            if(input != null) {
                byte[] buffer = new byte[1000];
                int n;
                while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                    System.out.println(new String(buffer));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
