package com.example.jucdemo.demo1;

public class ConcurrentProblem implements Runnable{

    private static int count;
    private static ConcurrentProblem concurrentProblem = new ConcurrentProblem();


    public static void main(String[] args) {
        Thread thread1 = new Thread(concurrentProblem);
        Thread thread2 = new Thread(concurrentProblem);
        thread1.start();
        thread2.start();
        try {
            // 等待两个线程都运行结束后，再打印结果
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //期待结果是20000，但是结果会小于这个值
        System.out.println(count);
    }


    @Override
    public void run() {
        for (int k = 0; k < 10000; k++) {
            count++;
        }
    }
}
