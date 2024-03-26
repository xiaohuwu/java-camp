package com.ktb.muke;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 现在有2000个客户端同时请求，
 * 但是服务器只允许200个客户端同时修改。
 * 并打印出最后的结果
 *
 *
 * 当我们往一个容器添加元素的时候，不直接往当前容器添加，而是先将当前容器进行Copy，复制出一个新的容器，
 * 然后新的容器里添加元素，添加完元素之后，再将原容器的引用指向新的容器。
 * 但是在添加这个数据的期间，其他线程如果要去读取数据，仍然是读取到旧的容器里的数据。
 */
public class CopyOnWriteArrayListDemo {
    //    public static AtomicInteger anInt = new AtomicInteger(0);
//    private static List<Integer> list = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(200);
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5000; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        countNumber(finalI);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("list.size() = " + list.size());
    }

    private static  void countNumber(int j) {
        list.add(j);
    }
}
