package com.wen.build;

public class House {
    private String door;
    private String wall;
    private String floor;

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "door='" + door + '\'' +
                ", wall='" + wall + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
