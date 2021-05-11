package com.ktb;

public class Darts {
    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        double distance = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
        System.out.println("distance:"+ distance);
//
//        if (x >= -1 && x <= 1 && y >= -1 && y <= 1) {
//            return 10;
//        } else if (x >= -5 && x <= 5 && y >= -5 && y <= 5) {
//            return 5;
//        } else if (x >= -10 && x <= 10 && y >= -10 && y <= 10) {
//            return 1;
//        }
        if (distance <= 1) {
            return 10;
        } else if (distance <= 5) {
            return 5;
        } else if (distance <= 10) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Darts darts = new Darts(-9, 9);
        System.out.println("score:=======>"+ darts.score());
    }
}
