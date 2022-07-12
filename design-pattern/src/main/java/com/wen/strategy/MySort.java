package com.wen.strategy;

public class MySort {
    private AbsSort absSort;

    public AbsSort getAbsSort() {
        return absSort;
    }

    public void setAbsSort(AbsSort absSort) {
        this.absSort = absSort;
    }

    public int[] sort(int[] arr) {
        return absSort.sort(arr);
    }
}
