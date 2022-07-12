package com.wen.Adapter;

public class Phone {
    public void getPower(Power5V power5V) {
        if (power5V.outPower5V() == 5) {
            System.out.println("适配成功");
        } else {
            System.out.println("适配不成功");
        }

    }
}
