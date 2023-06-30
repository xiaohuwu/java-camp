package com.ktb.atguigu;

import java.util.Arrays;

public class MyArray<T> {
    T[] arr;
    int size;

    public MyArray(int capacity) {
        this.arr = (T[]) new Object[capacity];
        size = 0;
    }

    public MyArray() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T e) {
        addItem(0, e);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("参数不合法");
        }
        return arr[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("参数不合法");
        }
        arr[index] = value;
    }

    public boolean contain(T value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int find(T value) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        T item = arr[index];
        for (int k = index; k <= size - 2; k++) {
            arr[k] = arr[k + 1];
        }
        size--;
        return item;
    }


    public void removeElement(T e) {
        int i = find(e);
        remove(i);
    }


    public void addLast(T e) {
        addItem(size, e);
    }

    public void addItem(int index, T item) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        for (int k = size - 1; k >= index; k--) {
            arr[k + 1] = arr[k];
        }
        arr[index] = item;
        size++;
    }

    public void resize(int capacity) {
        T[] new_arr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    public void removeFirst() {
        remove(0);
    }

    public void show() {
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, arr.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(arr[i]);
            if (i != size - 1) res.append(", ");
        }
        res.append(']');
        return res.toString();
    }


    public static void main(String[] args) {

        MyArray arr = new MyArray(10);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        arr.show();

        arr.addFirst(-1);
        arr.show();
//
//        arr.remove(2);
//        arr.show();

//        arr.removeElement(4);
//        arr.show();
//
//        arr.removeFirst();
//        arr.show();

    }


}
