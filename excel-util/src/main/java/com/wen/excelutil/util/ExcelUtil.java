package com.wen.excelutil.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.wen.excelutil.entity.MyFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author calwen
 * @since 2022/9/5
 */

public class ExcelUtil {
    @Data
    public static class Excel<T> {
        private String name;
        //        private String Sheet;
        private List<String> head;
        private List<T> data;
        private Long size;


        public void write(HttpServletResponse resp) {
            try (ExcelWriter writer = EasyExcel.write(resp.getOutputStream()).build()) {
                resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                resp.setCharacterEncoding("utf-8");
                String fileName = URLEncoder.encode(name, "UTF-8").replaceAll("\\+", "%20");
                resp.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName);
                WriteSheet sheet = EasyExcel.writerSheet("sheet").build();
                ArrayList<List<String>> head = new ArrayList<>();
                head.add(this.head);
                writer.write(head, sheet);
                writer.write(data, sheet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static <T> Excel<T> init(String name, List<String> headList, List<T> data) {
        Excel<T> excel = new Excel<>();
        excel.setName(name);
        excel.setHead(headList);
        excel.setData(data);
        return excel;
    }


}
