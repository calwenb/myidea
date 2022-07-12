package com.wen.oom;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        f();
    }

    static void f() {
        List<Byte[]> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(new Byte[1024 * 1024]);//每次1M
                i++;
                if (i % 700 == 0) {
                    System.out.println("次数: " + i);
                   // list.clear();
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("次数: " + i);
        }
    }
}
