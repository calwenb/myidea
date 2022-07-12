package com.wen.factory.simplefactory;

public class AndroidPhon implements Phone {
    @Override
    public void runSystem() {
        System.out.println("这是安卓手机，运行的是 android 系统");
    }
}
