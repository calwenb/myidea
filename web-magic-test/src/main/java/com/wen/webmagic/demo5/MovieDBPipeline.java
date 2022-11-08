package com.wen.webmagic.demo5;

import java.sql.SQLOutput;
import java.util.Date;

import cn.hutool.core.date.DateUtil;
import com.wen.webmagic.demo5.entity.MovieEntity;
import com.wen.webmagic.demo5.entity.ResourceEntity;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

public class MovieDBPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        String content = resultItems.get("content");
        String resourceLink = resultItems.get("resourceLink");
        if (!StringUtils.isAnyBlank(content,resourceLink)) {
            MovieEntity movieEntity = parseMovieEntity(content);
            System.out.println(movieEntity);

            ResourceEntity resourceEntity = new ResourceEntity();
            resourceEntity.setType("电影");//
            resourceEntity.setResourceLink(resourceLink);
            System.out.println(resourceEntity);
        }

/*        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println("=========");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();
        }*/
    }


    private MovieEntity parseMovieEntity(String content) {
        MovieEntity movie = new MovieEntity();
        String[] arr = content.split("◎");
        for (String s : arr) {
            if (s.length() < 7) {
                continue;
            }
            String key = s.substring(0, 4);
            String value = s.substring(5);
            switch (key) {
                case "译　　名":
                    movie.setOtherName(value);
                    break;
                case "片　　名":
                    movie.setName(value);
                    break;
                case "年　　代":
                    movie.setReleaseYear(value);
                    break;
                case "产　　地":
                    movie.setRegion(value);
                    break;
                case "类　　别":
                    movie.setType(value);
                    break;
                case "语　　言":
                    movie.setLanguage(value);
                    break;
                case "上映日期":
                    String dateStr = value.substring(0, 10);
                    movie.setReleaseTime(DateUtil.parseDate(dateStr));
                    break;
                case "豆瓣评分":
                    movie.setScore(value);
                    break;
                case "片　　长":
                    String minute = value.substring(0, value.indexOf("分钟"));
                    movie.setTime(Integer.valueOf(minute));
                    break;
                case "演　　员":
                    movie.setActor(value);
                    break;
                case "简　　介":
                    movie.setIntro(value);
                    break;
            }
        }
        return movie;
    }
}
