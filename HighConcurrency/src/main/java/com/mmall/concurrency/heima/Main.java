package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {
        CompletableFuture.runAsync(() -> {
            FileReader.read(Constants.MP4_FULL_PATH);
        });
        log.debug("do other things ...");
        System.in.read();
    }

}
