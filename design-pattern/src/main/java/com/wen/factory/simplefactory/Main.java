package com.wen.factory.simplefactory;

/**
 * 简单工厂模式
 * 具体实现：
 * 1. 一个产品接口
 * 2. 多个产品类实现这个接口
 * 3. 工厂类 根据 调用的传入的参数 创建不通的对象返回
 * 应用场景：
 * 客户端类要构建一个 对象，不需要知道构建对象的细节。
 */
public class Main {
    public static void main(String[] args) {
        Phone iosPhone = PhonFactory.productionPhone(PhonFactory.TYPE_IOS);
        iosPhone.runSystem();
        Phone androidPhon = PhonFactory.productionPhone(PhonFactory.TYPE_ANDROID);
        androidPhon.runSystem();
    }
}
