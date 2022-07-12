package com.wen.template;

public abstract class AbstractClass {
    public void TemplateMethod() {
        methodA();
        methodB();
        methodC();
        methodD();
    }

    public void methodA() {
        System.out.println("A方法");
    }

    public void methodB() {
        System.out.println("B方法");
    }

    public abstract void methodC();

    public abstract void methodD();

}
