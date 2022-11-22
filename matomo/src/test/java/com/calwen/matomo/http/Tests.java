package com.calwen.matomo.http;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author calwen
 * @since 2022/11/22
 */
public class Tests {
    @Test
    public void t1() {
        HashMap<String, Object> map = new HashMap<>();
//        String s = HttpUtil.get("http://1.117.95.71/index.php", map);
        map.put("module", "API");
        map.put("format", "JSON");
        map.put("token_auth", "5b0b4c69900938d1eb5be8ff4fda38e2");
        map.put("date", "2022-01-03,2023-01-11");
        map.put("period", "range");
        map.put("idSite", "1");
        map.put("method", "VisitorInterest.getNumberOfVisitsPerVisitDuration");


        String rs = HttpUtil.get("http://1.117.95.71/index.php", map);
        System.out.println(rs);
        JSONArray array = JSON.parseArray(rs);
        for (Object o : array) {
            Map json = JSON.parseObject(String.valueOf(o));
            System.out.println(json);
        }
    }
}
