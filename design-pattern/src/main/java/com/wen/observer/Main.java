package com.wen.observer;

/**
 * 观察者模式：
 * 原理：
 * 1.在要监听的业务上继承AbstractRate类，
 * 2.AbstractRate类有looks，改变时通知观察者
 * 3.当监听的业务发生了改变时会通知looks里面的look
 * 使用场景：
 * 1.业务中一个对象发生改变，其他的对象也要做出改变的的时候
 * 2.多个对象 监听 一个对象的改变
 */
public class Main {
    public static void main(String[] args) {
        Rate rate = new Rate();
        rate.addLook(new LookUp());
        rate.addLook(new LookDecline());
        rate.change(20);
        rate.change(1);
        rate.change(60);
        rate.change(20);
        rate.change(30);
    }
}
