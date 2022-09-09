package com.wen.excelutil.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.wen.excelutil.entity.MyFile;
import com.wen.excelutil.service.FileService;
import com.wen.excelutil.util.ExcelUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author calwen
 * @since 2022/9/5
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    FileService fileService;

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<MyFile> list = fileService.listAll();
        list.forEach(System.out::println);

        List<String> head = new ArrayList<>();
        head.add("wen1");
        head.add("wen2");
        ExcelUtil.init("wen.csv", head, list)
                .write(response);

//        List<String> head = new ArrayList<>();
//        head.add("wen1");
//        head.add("wen2");
//        EasyExcel.write(response.getOutputStream(), MyFile.class)
//                .sheet("test")
//                .doWrite(list);
    }

}
