package com.example.xuefeng.designmode;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class AdapterDemo {
    public static void main(String[] args) throws IOException {
        Callable<Long> callable = new Task(5L);
        Thread thread = new Thread(new RunnableAdapter(callable)); // compile error!
        thread.start();


        String[] exist = new String[] {"Good", "morning", "Bob", "and", "Alice"};
        Set<String> set = new HashSet<>(Arrays.asList(exist));

        InputStream input = Files.newInputStream(Paths.get("/path/to/file"));
        Reader reader = new InputStreamReader(input, "UTF-8");
    }
}

class RunnableAdapter implements Runnable{
    Callable callable;

    public RunnableAdapter(Callable callable) {
        this.callable = callable;
    }

    @SneakyThrows
    @Override
    public void run() {
        callable.call();
    }

}

class Task implements Callable<Long> {

    private long num;
    public Task(long num) {
        this.num = num;
    }

    public Long call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }

}