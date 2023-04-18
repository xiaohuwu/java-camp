package com.example.jucdemo.basic;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue<String> q = new ArrayQueue<>(3);
        q.add("A");
        q.add("B");
        q.add("B");
        q.add("B");
        q.add("B");
    }
}
