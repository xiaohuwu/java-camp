package com.example.itstackdemonettyhello.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        //思路
//1. 创建一个线程池
//2. 如果有客户端连接，就创建一个线程，与之通讯(单独写一个方法)
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//创建 ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true) {
            System.out.println(" 线 程 信 息 id =" + Thread.currentThread().getId() + " 名 字 =" + Thread.currentThread().getName());
//监听，等待客户端连接 System.out.println("等待连接....");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
//就创建一个线程，与之通讯(单独写一个方法)
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    private static void handler(Socket socket) {
        try {
            System.out.println(" 线 程 信 息 id =" + Thread.currentThread().getId() + " 名 字 =" +
                    Thread.currentThread().getName());

            InputStreamReader inSR = null;
            OutputStreamWriter outSW = null;

            byte[] bytes = new byte[1024];
            //通过 socket 获取输入流
            InputStream inputStream = socket.getInputStream();
//            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            while (true) {
                System.out.println(" 线 程 信 息 id =" + Thread.currentThread().getId() + " 名 字 =" +
                        Thread.currentThread().getName());
                System.out.println("read....");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    byte[] used = new byte[read];
                    for (int k = 0; k < read; k++) {
                        used[k] = bytes[k];
                    }
                    System.out.println("read:" + new String(used, "utf-8"));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}