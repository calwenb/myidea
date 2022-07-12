package com.wen.prototype;

/**
 * 原形模式
 * 原理：
 * 1.在原形类中 实现 Cloneable 接口，在重写clone 方法 返回需要的对象。
 * 2.深拷贝：在类里面的成员属性为对象变量时，还需在对象变量类里面进行 拷贝
 * <p>
 * 应用场景：当需要创建另外的对象，只是个别的几个属性不同的时候
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation wenCitation = new Citation("wen", "三好学生", "行健");
        wenCitation.print();
        Citation haiCitation = wenCitation.clone();
        haiCitation.setName("hai");
        haiCitation.print();
    }
}
