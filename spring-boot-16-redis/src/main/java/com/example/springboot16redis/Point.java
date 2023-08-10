package com.example.springboot16redis;

import java.io.IOException;
import java.rmi.AccessException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Point extends Object {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
//        Point p1 = new Point(1, 2);
//        Point p2 = new Point(1, 2);
//        System.out.println(p1.equals(p2));// true
//
//        Map<Point, String> map = new HashMap<>();
//        map.put(p1, "p1");
//        map.put(p2, "p2");
//        for (Map.Entry<Point, String> pointStringEntry : map.entrySet()) {
//            System.out.println(pointStringEntry.getKey());
//        }
//        System.out.println(map.get(p2)); //


        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.ALL);
        for (Handler handler : logger.getHandlers()) {
            handler.setLevel(Level.ALL);
        }
        logger.fine("this is my hello world");





        try {
//            process1();
            process2();
            process3();
        } catch (IOException | NumberFormatException e) { // IOException或NumberFormatException
            System.out.println("Bad input");
        } catch (Exception e) {
            System.out.println("Unknown error");
        }
    }

    public static void process1(){
        throw new  NumberFormatException();
    }

    public static void process2() throws IOException {
        throw new  IOException();
    }

    public static void process3() throws AccessException {
        throw new AccessException("");
    }


}
