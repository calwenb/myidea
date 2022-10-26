package com.wen.webmagic.demo5;

import org.omg.PortableServer.POA;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Arrays;
import java.util.List;

public class MovieSpider implements PageProcessor {

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(".*/html/gndy/dyzz/[0-9]{8}/[0-9]{5}.html").match()) {
            page.putField("content", page.getHtml().xpath("//*[@id=\"Zoom\"]/span/text()").toString());
            page.putField("resourceLink", page.getHtml().xpath("//*[@id=\"Zoom\"]/span/a/@href"));
        } else {
            page.addTargetRequests(page.getHtml().xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/ul/table/tbody/tr[2]/td[2]/b/a/@href").all());
//            System.out.println(page.getHtml().xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/ul/table/tbody/tr[2]/td[2]/b/a/@href").all());
        }
        Selectable nextPage = page.getHtml().xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[7]/@href");
        System.out.println(nextPage);

    }
}
