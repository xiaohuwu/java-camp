package com.atguigu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        // ����һ���̶���С���̳߳�
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // ǿ��ת��ΪThreadPoolExecutor���Ա�����̳߳ص�״̬����
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;

        // �ύһЩ������̳߳�ִ��
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Executing task " + taskId + " using thread " + Thread.currentThread().getName());
                try {
                    // ����ִ��һ��ʱ��
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // ģ������һ��ʱ����ȡ�̳߳�״̬
        Thread.sleep(3000); // �ȴ�һЩ�������

        // ��ȡ����ӡ�̳߳ص�״̬��Ϣ
        System.out.println("Pool Size: " + pool.getPoolSize());
        System.out.println("Active Threads: " + pool.getActiveCount());
        System.out.println("Completed Tasks: " + pool.getCompletedTaskCount());
        System.out.println("Total Tasks: " + pool.getTaskCount());

        // �ر��̳߳�
        executorService.shutdown();
    }
}

