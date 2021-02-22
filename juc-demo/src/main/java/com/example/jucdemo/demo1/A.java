package com.example.jucdemo.demo1;

//线程同步的写法1;
public class A {

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

}

class Data {
    private int number = 0;
    //+1
    public synchronized void increment() throws InterruptedException {
        if (number != 0) {  //0
            // 等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number); // 通知其他线程，我+1完毕了
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        if (number == 0) { // 1
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number); // 通知其他线程，我-1完毕了
        this.notifyAll();
    }
}