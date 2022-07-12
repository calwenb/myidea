package com.wen.Adapter;

public class ChangeAdapter extends Power220V implements Power5V {

    @Override
    public int outPower5V() {
        int outPower = super.outPower220V() / 44;
        return outPower;
    }
}
