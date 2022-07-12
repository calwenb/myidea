package com.wen.strategy;

import java.util.Arrays;

public class SortA extends AbsSort {
    @Override
    public int[] sort(int[] arr) {
        System.out.println("快排算法");
        Arrays.sort(arr);
        return arr;
    }
}
