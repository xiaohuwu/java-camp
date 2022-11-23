package com.ktb.atguigu;

import java.util.Arrays;

public class Array {
    int[] arr;
    int size;

    public Array(int capacity) {
        this.arr = new int[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int e){
        addItem(0, e);
    }

    public void addLast(int e){
        addItem(size, e);
    }

    public void addItem(int index,int item){
        if (size == arr.length) {
            throw new RuntimeException("数组满了");
        }
        for(int k = size - 1; k >= index; k-- ) {
            arr[k+1] = arr[k];
        }
        arr[index] = item;
        size++;
    }

    public void show(){
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }


}
