package com.ktb.mutithread;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
   public  Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            System.out.println("while");
        }
        return queue.remove();
    }


}
