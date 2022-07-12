package com.wen.Adapter;

/**
 * 适配器模式
 * 原理：
 * 1. A为被适配类，B为使用类，C适配器类：B要使用A
 * 2. B 中传入适配后的接口，A适配器类继承C适配器类，并继承实现适配后的接口
 * 2. C适配器类中做兼容处理
 * 应用场景：当一个类和另外一个类不兼容，可以适配器处理类和类之间的兼容
 */
public class Main {
    public static void main(String[] args) {
        ChangeAdapter adapter = new ChangeAdapter();
        Phone phone = new Phone();
        phone.getPower(adapter);
    }
}
