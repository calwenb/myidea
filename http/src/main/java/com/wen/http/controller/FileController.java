package com.wen.http.controller;

import com.overzealous.remark.Remark;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/8/10
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/data")
    public void data(HttpServletResponse resp) throws IOException {

        ServletOutputStream out;
        try {
            Path path = Paths.get("D:\\Users\\Desktop\\tp\\html-md.txt");
            byte[] bytesF = Files.readAllBytes(path);
            String html = new String(bytesF);

            String convert = new Remark().convert(html);
            byte[] bytes = convert.getBytes();

            String fileName = "html-md.md";
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-disposition", "attachment;filename=" + fileName);
            out = resp.getOutputStream();
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            resp.flushBuffer();
        }
    }
}
