package com.ktb.design_pattern.decorator;

public class TeslaCar  implements Car{

    @Override
    public void run() {
        System.out.println("特斯拉开车了！");
    }
}
