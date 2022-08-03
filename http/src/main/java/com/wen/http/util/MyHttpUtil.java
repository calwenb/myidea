package com.wen.http.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/8/3
 */
public class MyHttpUtil {
    public static void sendGet() {
        //拼接 url 环境+api-url+路径变量
//        String url = "http://localhost:8999/"+"";
        String env = "http://localhost:8999";
        String apiUrl = "/dev-api-folder/list/%s";
        //多个
        String pathParam = "0";


        Map<String, Object> reqForms = new HashMap<>();
        Map<String, String> reqHeaders = new HashMap<>();
        String url = env + String.format(apiUrl, pathParam);
        String repBody = "";

        reqHeaders.put("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI3ODAxIiwiZXhwIjoxNjY1NTY1NDYxfQ.AgVuqIPSfJ28SBJ2fkzWTAzOTMZry2WptxagcDid8wIL1Us-XWJ3ZVQg-rjImoo9rFGGZ1wXayXWD7ZBm0Xgsw");


        HttpResponse response = HttpRequest.get(url)
                .form(reqForms)
                .body(repBody)
                .headerMap(reqHeaders, true)
                .execute();
        Map<String, List<String>> respHeaders = response.headers();
        String respBody = response.body();
        int respStatus = response.getStatus();

        System.out.println("respBody==> " + respBody);
        System.out.println("respStatus==> " + respStatus);
        System.out.println("respHeaders==> " + respHeaders);


    }

}
