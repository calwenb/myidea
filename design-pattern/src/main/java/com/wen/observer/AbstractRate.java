package com.wen.observer;

import java.util.ArrayList;

public abstract class AbstractRate {

    ArrayList<Look> looks = new ArrayList<>();

    public void addLook(Look look) {
        looks.add(look);
    }

    public void removeLooks(Look look) {
        looks.remove(look);
    }

    public abstract void change(int changeRate);

    public abstract void informLooks(int nowRate);

}
