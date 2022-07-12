package com.wen.observer;

public class LookDecline implements Look {
    @Override
    public void report(int nowRate, int changeRate) {
        int change = changeRate - nowRate;
        if (change < 0) {
            System.out.println("观察者2 发现汇率下降: " + change + " 当前为: " + changeRate );
        }

    }
}
