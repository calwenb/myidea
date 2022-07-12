package com.wen.build;

public class Worker implements Builder {
    private House house;

    public Worker() {
        house = new House();
    }

    @Override
    public void buildDoor() {
        house.setDoor("大门");
    }

    @Override
    public void buildWall() {
        house.setWall("绿墙");
    }

    @Override
    public void buildFool() {
        house.setFloor("木地板");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
