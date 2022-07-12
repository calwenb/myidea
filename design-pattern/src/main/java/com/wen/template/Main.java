package com.wen.template;

/**
 * 模板模式
 * 原理：
 * 1.AbstractClass提取公共的方法，写组合方法顺序的对外方法
 * 2.ConcreteClass子类 写具体方法，
 * 3. main调用
 * 应用场景：
 * 1. 算法的整体步骤很固定，但其中个别部分易变时，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。
 */
public class Main {
    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.TemplateMethod();
    }
}
