package com.wen.webmagic.demo5;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

public class MovieDBPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println("=========");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();
        }

    }
}
