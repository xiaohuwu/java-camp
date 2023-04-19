package com.example.file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URI resource = FilesDemo.class.getClassLoader().getResource("application.properties").toURI();
        byte[] data = Files.readAllBytes(Paths.get(resource));
        String s = new String(data);
        System.out.println("s = " + s);
//        List<String> strings = Files.readAllLines(Paths.get(resource));
//        strings.stream().forEach(System.out::println);
        Files.write(Paths.get(resource),"666".getBytes());
    }
}
