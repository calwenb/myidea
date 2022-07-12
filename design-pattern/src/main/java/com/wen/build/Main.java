package com.wen.build;

/**
 * 创建者模式
 * 原理：
 * 1.创建者的接口，多个创建者类，去创建者类
 * 2.指挥者调用创建者的方法顺序逻辑执行
 * <p>
 * 应用场景：
 * 1.创建更复杂的对象时。
 * 2.创建对象时 需要对立面的属性有顺序
 */
public class Main {
    public static void main(String[] args) {
        House house = new Director().builder(new Worker());
        System.out.println(house);
    }
}
