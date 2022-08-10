package com.wen.md;

import com.overzealous.remark.Remark;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/8/10
 */
public class Test {
    public static void main(String[] args) throws IOException {


//        JSoupUtil jSoupUtil = new JSoupUtil();
//        String html = jSoupUtil.getHtml("https://apistudio.om.dianhun.cn/view/doc/60f438dd");
        String fileName = "D:\\Users\\Desktop\\tp\\html-md.txt";
        Path path = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(path);
        System.out.println();
        String html = new String(bytes);
        Remark remark = new Remark();
        String convert = remark.convert(html);
        System.out.println(convert);

    }
}
