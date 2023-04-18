package com.example.jucdemo.basic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getLevel().charAt(0) == 'v') { //vip先走
                    return -1;
                }
                return 1;
            }
        });
        q.add(new User("A", "normal"));
        q.add(new User("B", "normal"));
        q.add(new User("boss", "vip"));
        User poll = q.poll();
        User poll1 = q.poll();
        User poll2 = q.poll();
        System.out.println("poll = " + poll);
        System.out.println("poll1 = " + poll1);
        System.out.println("poll2 = " + poll2);
    }


    static class User {
        private String name;
        private String level;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", level='" + level + '\'' +
                    '}';
        }

        public User(String name, String level) {
            this.name = name;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}
