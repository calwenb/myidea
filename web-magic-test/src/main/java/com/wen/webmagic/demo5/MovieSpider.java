package com.wen.webmagic.demo5;

import cn.hutool.core.date.DateUtil;
import com.wen.webmagic.demo5.entity.MovieEntity;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MovieSpider implements PageProcessor {

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    public Site getSite() {
        return Site.me().setRetryTimes(3).setSleepTime(100);
    }

    //统计
    public static int count = 0;
    //限制
    private static volatile int limit = 2;

    @Override
    public void process(Page page) {
        boolean steal = false;
        if (limit < 0) {
            return;
        }
        //爬取资源详情
        if (page.getUrl().regex(".*/html/gndy/dyzz/[0-9]{8}/[0-9]{5}.html").match()) {
            page.putField("content", page.getHtml().xpath("//*[@id=\"Zoom\"]/span/text()").toString());
            page.putField("resourceLink", String.valueOf(page.getHtml().xpath("//*[@id=\"Zoom\"]/span/a/@href")));
            count++;
            limit--;
        } else {
            page.addTargetRequests(page.getHtml().xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/ul/table/tbody/tr[2]/td[2]/b/a/@href").all());
        }

        int nextIndex = page.getHtml().xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a/text()").all().indexOf("下一页");
        // 下一页
        if (nextIndex != -1) {
            String nextUrl = page.getHtml().xpath("//*[@id=\"header\"]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/a[" + (nextIndex + 1) + "]/@href").toString();
            page.addTargetRequest(nextUrl);
        }
    }

}
