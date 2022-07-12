package com.wen.singleton;

/**
 * 饿汉式
 * @author Mr.文
 */
public class SingletonHungry {
    private static Resource resource = new Resource();

    private SingletonHungry() {
    }

    public Resource getResource() {
        return resource;
    }
}
