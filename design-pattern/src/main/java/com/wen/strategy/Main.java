package com.wen.strategy;

import java.util.Arrays;

/**
 * 策略模式：
 * 原理：
 * 1.AbsSort策略的基类，A，B为具体策略类。
 * 2.MySort 环境类，在AB<——MySort<—— mian
 * 应用场景：
 * 1.当业务需要不同的实现方案/策略
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        System.out.println("now:" + Arrays.toString(arr));
        MySort mySort = new MySort();
        mySort.setAbsSort(new SortA());
        mySort.sort(arr);
        System.out.println("A算法:" + Arrays.toString(arr));
        mySort.setAbsSort(new SortB());
        mySort.sort(arr);
        System.out.println("B算法:" + Arrays.toString(arr));
    }
}
