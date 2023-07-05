package com.ktb.mutithread;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
@Slf4j
public class TestGuardedObject {
    static GuardedObject guardedObject = new GuardedObject();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<String> download = Downloader.download();
                    guardedObject.put(download);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        log.debug("waiting...");
        List<String> o = (List<String>) guardedObject.get();
        System.out.println("size = " + o.size());

    }
}

class GuardedObject {

    public Object response;

    private Object lock = new Object();

    public Object get() {
        synchronized (lock) {
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void put(Object response) {
        this.response = response;
        synchronized (lock) {
            lock.notifyAll();
        }
    }


}

