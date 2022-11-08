package com.calwen.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.calwen.entity.Resource;
import jdk.nashorn.internal.ir.IfNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author calwen
 * @since 2022/11/8
 */
public class ExcelService {

    public HashMap<String, List<Resource>> readResource() {
        HashMap<String, List<Resource>> map = new HashMap<>();

        for (int s = 1; s < 10; s++) {
            String key = "";
            ExcelReader reader = ExcelUtil.getReader(FileUtil.file("E:\\wen-other\\个人\\1.xls"), s);
            List<List<Object>> data = reader.read();
            List<Resource> list = new ArrayList<>();
            boolean isData = false;
            int nameI = 0, versionI = 0, userI = 0, returnUse = 0;
            for (int i = 0; i < data.size(); i++) {
                List<Object> h = data.get(i);
                if (h.contains("工程名称")) {
                    key = String.valueOf(h.get(h.indexOf("工程名称") + 1));
                    continue;
                }
                if (h.contains("材料领用名称")) {
                    nameI = h.indexOf("材料领用名称");
                    versionI = h.indexOf("规格及型号");
                    userI = h.indexOf("实际消耗量");
                    if (userI == -1) {
                        userI = h.indexOf("实消耗量");
                    }
                    returnUse = h.indexOf("退库数量");
                    isData = true;
                    continue;
                }

                if (isData) {
                    if (h.get(0).equals(h.get(1))) {
                        break;
                    }
                    Resource model = new Resource();
                    model.setName(String.valueOf(h.get(nameI)));
                    model.setVersion(String.valueOf(h.get(versionI)));
                    model.setUse(Double.valueOf(String.valueOf(h.get(userI))));
                    model.setReturnUse(Double.valueOf(String.valueOf(h.get(returnUse))));
                    list.add(model);
                }
            }

            map.put(key, list);
        }
        map.forEach((k, v) -> {
            System.out.println("=======> k:  " + k);
            System.out.println("=======> v:  ");
            v.forEach(System.out::println);
        });

        return map;
    }

    public List<Map<String, Object>> readTarget() {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("E:\\wen-other\\个人\\2.xlsx"));
        List<Map<String, Object>> map
                = reader.read(0, 1, Integer.MAX_VALUE);
        map = map.stream().filter(e -> {
            if (StrUtil.isBlank(String.valueOf(e.get("合同编号")))) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        map.remove(map.size() - 1);
        map.remove(map.size() - 1);
        map.forEach(System.out::println);
        return map;
    }

    public void handle() {
        readResource();
        List<Map<String, Object>> mapList = readTarget();
    }
}
