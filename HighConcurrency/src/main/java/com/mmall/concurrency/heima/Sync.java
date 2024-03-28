package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sync {
    public static void main(String[] args) {
        new Thread(() -> {
            FileReader.read(Constants.MP4_FULL_PATH);
        }).start();
        log.debug("do other things ...");
    }

}
