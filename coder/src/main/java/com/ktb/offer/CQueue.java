package com.ktb.offer;

import java.util.Stack;

/**
 * https://leetcode.cn/leetbook/read/illustrate-lcof/xz34lh/
 * 剑指 Offer 09. 用两个栈实现队列 - 解决方案
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(Integer param) {
        stack1.push(param);
    }

    public Integer deleteHead() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        Integer integer = cQueue.deleteHead();
        System.out.println("integer = " + integer);
        integer = cQueue.deleteHead();
        System.out.println("integer = " + integer);
        integer = cQueue.deleteHead();
        System.out.println("integer = " + integer);
    }

}
