package com.wen.strategy;

import java.util.Arrays;

public class SortB extends AbsSort {
    @Override
    public int[] sort(int[] arr) {
        System.out.println("heap算法");
        Arrays.sort(arr);
        return arr;
    }
}
