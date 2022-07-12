package com.wen.prototype;

/**
 * 奖状类
 */
public class Citation implements Cloneable {
    private String name;
    private String type;
    private String school;

    public Citation(String name, String type, String school) {
        System.out.println("创建类");
        this.name = name;
        this.type = type;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(" name:" + name + " type:" + type + " school" + school);
    }


    @Override
    protected Citation clone() throws CloneNotSupportedException {
        System.out.println("克隆");
        return (Citation) super.clone();
    }
}
