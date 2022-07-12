package com.wen.observer;

public class Rate extends AbstractRate {
    private int nowRate = 10;

    @Override
    public void change(int changeRate) {
        if (changeRate != nowRate) {
            informLooks(changeRate);
            nowRate = changeRate;
        }
    }

    @Override
    public void informLooks(int changeRate) {
        for (Look look : looks) {
            look.report(nowRate, changeRate);
        }
    }
}
