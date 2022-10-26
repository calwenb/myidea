package com.wen.webmagic.demo3;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobProcessor implements PageProcessor {
    private final Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public void process(Page page) {
        page.putField("author", page.getHtml().all());
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                //初始访问url地址
                .addUrl("https://www.btnull.re/")
                .run();
    }
}
