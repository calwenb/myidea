package com.wen.singleton;

/**
 * 懒汉式
 *
 * @author Mr.文
 */
public class SingletonLazy {
    private volatile Resource resource;

    private SingletonLazy() {

    }

    public Resource getResource() {
        if (resource == null) {
            synchronized (SingletonLazy.class) {
                if (resource == null) {
                    this.resource = new Resource();
                }
            }
        }
        return resource;
    }
}
