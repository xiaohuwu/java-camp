package com.ktb.mutithread;

import java.util.ArrayList;

public class TestThreadSafe {
    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafeSub();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                        threadSafe.method1(200);
                    }

            }).start();
        }
    }
}

class ThreadSafe{

    public void method1(int number) {
        ArrayList<String> list = new ArrayList<>();
        for (int j = 0; j < number; j++) {
            method2(list);
            method3(list);
        }

    }

    private void method2(ArrayList<String> list) {
        list.add("A");
    }

    public void method3(ArrayList<String> list) {
        list.remove(0);
    }

}


class ThreadSafeSub extends ThreadSafe{
    @Override
    public void method3(ArrayList<String> list) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                list.remove(0);
            }
        }).start();
    }
}
