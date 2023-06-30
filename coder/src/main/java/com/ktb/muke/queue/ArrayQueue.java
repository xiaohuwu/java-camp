package com.ktb.muke.queue;

import com.ktb.muke.Array;

public class ArrayQueue<T> {

    Array<T> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }


    public ArrayQueue(){
        array = new Array<>();
    }

    public int getSize(){
        return array.getSize();
    }

    public void enqueue(T e) {
        array.addLast(e);
    }

    public T dequeue() {
        return array.removeFirst();
    }

    public T getFront(T e) {
        return array.getFirst();
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }



    public static void main(String[] args){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
