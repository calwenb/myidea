package com.wen.webmagic.demo5;

import us.codecraft.webmagic.Spider;

public class Main {
    public static void main(String[] args) {
        Spider.create(new MovieSpider())
                .addUrl("https://www.ygdy8.net/html/gndy/dyzz/index.html")
                .thread(5)
                .run();
    }


    /*String[] split = s.split("◎");
            for (String s1 : split) {
        System.out.println(s1);
    }*/
}
