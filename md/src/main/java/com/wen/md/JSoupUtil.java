package com.wen.md;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/8/10
 */
public class JSoupUtil {
    public String getHtml(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String html = document.html();

        return html;
    }
}
