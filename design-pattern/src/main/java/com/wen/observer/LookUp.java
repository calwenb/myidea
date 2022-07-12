package com.wen.observer;

public class LookUp implements Look {
    @Override
    public void report(int nowRate, int changeRate) {
        int change = changeRate - nowRate;
        if (change > 0) {
            System.out.println("观察者1 发现汇率上升: " + change + " 当前为: " + changeRate );
        }
    }
}
