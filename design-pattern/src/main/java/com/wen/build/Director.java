package com.wen.build;

public class Director {

    public House builder(Builder builder) {
        builder.buildDoor();
        builder.buildFool();
        builder.buildWall();
        return builder.getHouse();
    }
}
