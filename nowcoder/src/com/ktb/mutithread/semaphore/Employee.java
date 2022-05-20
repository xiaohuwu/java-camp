package com.ktb.mutithread.semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Employee implements Runnable {

    private String id;
    private Semaphore semaphore;
    private static Random rand= new Random(47);


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id='").append(id).append('\'');
        sb.append(", semaphore=").append(semaphore);
        sb.append(", sdf=").append(sdf);
        sb.append('}');
        return sb.toString();
    }

    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Employee(String id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println( this.id + " is using the toilet ");
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            semaphore.release();
            System.out.println(this.id +  "is leaving ");
        } catch (InterruptedException e) {
        }
    }


}
