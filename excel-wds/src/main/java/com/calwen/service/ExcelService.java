package com.calwen.service;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.calwen.entity.Resource;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.apache.commons.compress.utils.Lists;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author calwen
 * @since 2022/11/8
 */
public class ExcelService {
    String baseDir = "C:\\Users\\Mr.wen\\Desktop\\bb\\tp\\";

    public HashMap<String, List<Resource>> readResource() {
        HashMap<String, List<Resource>> map = new HashMap<>();

        for (int s = 1; s < 10; s++) {
            String key = "";
            ExcelReader reader = ExcelUtil.getReader(FileUtil.file(baseDir + "1.xls"), s);
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
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file(baseDir + "2.xls"));
        List<Map<String, Object>> map = reader.readAll();
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

    public List<Map<String, Object>> handle2() {
        HashMap<String, List<Resource>> resourceSheet = readResource();
        System.out.println("数据分割 ============");
        List<Map<String, Object>> targetList = readTarget();
        System.out.println("开始处理 ===========");
        List<Map<String, Object>> rsList = new ArrayList<>();
        for (String projectName : resourceSheet.keySet()) {
            System.out.println("==========");
            Map<String, Object> map = new LinkedHashMap<>();
//            String projectName = String.valueOf(row.get("工程名称"));
//            int max = -1;
//            String maxStr = "-1";
//            for (String s : resourceSheet.keySet()) {
//                int i = FuzzySearch.partialRatio(s, projectName);
//                if (i > max) {
//                    max = i;
//                    maxStr = s;
//                }
//            }
//            System.out.println(max);
//            System.out.println(maxStr + "   " + projectName);
            List<Resource> resourceList = resourceSheet.get(projectName);
            map.put("工程名称", projectName);
            for (Resource resource : resourceList) {
                String resourceName = resource.getName();
                String version = resource.getVersion();
                String resourceKey = resourceName + version;
                Double use = resource.getUse();
                map.put(resourceKey, use);
            }

            rsList.add(map);
        }
//        for (Map<String, Object> row : targetList) {
//            System.out.println("==========");
//            Map<String, Object> map = new LinkedHashMap<>();
//            String projectName = String.valueOf(row.get("工程名称"));
////            int max = -1;
////            String maxStr = "-1";
////            for (String s : resourceSheet.keySet()) {
////                int i = FuzzySearch.partialRatio(s, projectName);
////                if (i > max) {
////                    max = i;
////                    maxStr = s;
////                }
////            }
////            System.out.println(max);
////            System.out.println(maxStr + "   " + projectName);
//            List<Resource> resourceList = resourceSheet.get(maxStr);
//            if (resourceList == null) {
//                System.out.println("000000000000");
////                System.out.println(projectName);
//                continue;
//            }
//            map.put("工程名称", projectName);
//            for (Resource resource : resourceList) {
//                String resourceName = resource.getName();
//                String version = resource.getVersion();
//                String resourceKey = resourceName + version;
//                Double use = resource.getUse();
//                map.put(resourceKey, use);
//            }
//
//            rsList.add(map);
//        }
        System.out.println("rsList ======");
        rsList.forEach(System.out::println);


        HashSet<String> keys = new HashSet<>();
        for (Map<String, Object> map : rsList) {
            keys.addAll(map.keySet());
        }
        int c = 0;
        System.out.println(keys.size());
        System.out.println(rsList.size());
        for (Map<String, Object> map : rsList) {
//            Object id = map.get("序号");
//            Object htId = map.get("合同编号");
//            Object pName = map.get("工程名称");
//            map.clear();
//            map.put("序号", id);
//            map.put("合同编号", htId);
//            map.put("工程名称", pName);
//
            for (String key : keys) {
                c++;
                if (!map.containsKey(key)) {
                    map.put(key, "");
                    continue;
                }

            }
        }

        System.out.println("rsList new  ======");
        rsList.forEach(System.out::println);
        System.out.println(c);

        return rsList;
    }

    public void save() {
        List<Map<String, Object>> data = handle2();
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file(baseDir + "2.xls"));
        List<Map<String, Object>> maps = reader.readAll();
        int i = 0;
        for (Map<String, Object> map : maps) {
            if (i >= data.size()) {
                break;
            }
//            System.out.println(map);
            System.out.println(data.get(i));
            map.putAll(data.get(i));
            i++;
        }
        System.out.println(maps);
        ExcelWriter writer = ExcelUtil.getWriter(baseDir + "3.xls");
        writer.write(maps, true);
        writer.close();

    }

    private int count = 0;

    public void handle() {
        HashMap<String, List<Resource>> resourceMap = readResource();
        System.out.println("数据分割 ============");
        List<Map<String, Object>> targetList = readTarget();
        System.out.println("开始处理 ===========");
        List<Map<String, Object>> rsList = new ArrayList<>();
        for (Map<String, Object> row : targetList) {
            HashMap<String, Object> map = new HashMap<>();
            Set<String> keys = row.keySet();
            String projectName = String.valueOf(row.get("工程名称"));
            List<Resource> resourceList = resourceMap.get(projectName);
            if (resourceList == null) {
                continue;
            }
            for (Resource resource : resourceList) {
                String resourceName = resource.getName();
                String version = resource.getVersion();
                String resourceKey = resourceName + version;
                Double use = resource.getUse();
                String matchKey = match(row, resourceKey);
                if (StrUtil.isNotBlank(matchKey)) {
                    map.put(matchKey, use);
                }
            }
            rsList.add(map);
        }
        System.out.println("rsList ======");
        rsList.forEach(System.out::println);
//        System.out.println(count);
        HashSet<String> keys = new HashSet<>();
        for (Map<String, Object> map : rsList) {
            keys.addAll(map.keySet());
        }
        for (Map<String, Object> map : rsList) {
            for (String key : keys) {
                if (!map.containsKey(key)) {
                    map.put(key, "");
                }
            }
        }

        System.out.println("rsList new  ======");
        rsList.forEach(System.out::println);
    }

    private String match(Map<String, Object> map, String resourceName) {
        String maxKey = "";
        // float MaxLeve = -1;
        int maxInt = -1;
        resourceName = rep(resourceName);
        for (String key : map.keySet()) {
            key = rep(key);
            int ratio = FuzzySearch.partialRatio(key, resourceName);
            if (ratio > maxInt) {
                maxKey = key;
                maxInt = ratio;
            }
//            System.out.println(ratio);
//            float levenshtein = levenshtein(key, resourceName);
//            if (levenshtein > MaxLeve) {
//                maxKey = key;
//                MaxLeve = levenshtein;
//            }
//            if (levenshtein > 0.8) {
//                System.out.println("====> key " + key + "   " + resourceName);
//                System.out.println(levenshtein);
//            }
        }
//
//        if (MaxLeve < 0.3) {
//            System.out.println(MaxLeve);
//            System.out.println(maxKey + "  " + resourceName);
//        }
        if (maxInt < 90) {
            count++;
            System.out.println("==============");
            System.out.println(maxKey + "  " + resourceName);
            System.out.println(maxInt);
        }
        return maxInt > 95 ? maxKey : "";

    }

    public String rep(String str) {
        str = str.replace(" ", "");
        String regex = "[a-zA-Z0-9\\u4E00-\\u9FA5]*";
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            sb.append(matcher.group(0));
        }
        return sb.toString();
    }

}
