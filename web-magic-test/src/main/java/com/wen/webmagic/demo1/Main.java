package com.wen.webmagic.demo1;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;

public class Main {
    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor())
                //从https://github.com/code4craft开始抓
                .addUrl("https://cn.bing.com/translator")
                //设置Scheduler，使用Redis来管理URL队列
//                .setScheduler(new RedisScheduler("localhost"))
                //设置Pipeline，将结果以json方式保存到文件
                .addPipeline(new ConsolePipeline())
                //开启5个线程同时执行
                .thread(5)
                //启动爬虫
                .run();
    }
}
