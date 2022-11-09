package com.calwen.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.calwen.entity.Resource;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        List<Map<String, Object>> map = reader.read(0, 1, Integer.MAX_VALUE);
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
                map.put(matchKey, use);
            }
            rsList.add(map);
        }
        System.out.println("rsList ======");
        rsList.forEach(System.out::println);

    }

    private String match(Map<String, Object> map, String resourceName) {
        String maxKey = "";
        float MaxLeve = -1;
        resourceName = rep(resourceName);
        for (String key : map.keySet()) {
            key = rep(key);
            float levenshtein = levenshtein(key, resourceName);
            if (levenshtein > MaxLeve) {
                maxKey = key;
                MaxLeve = levenshtein;
            }
//            if (levenshtein > 0.8) {
//                System.out.println("====> key " + key + "   " + resourceName);
//                System.out.println(levenshtein);
//            }
        }


        if (MaxLeve > 0.8) {
            System.out.println(MaxLeve);
            System.out.println(maxKey + "  " + resourceName);
        }
        return maxKey;

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

    public float levenshtein(String str1, String str2) {
        //计算两个字符串的长度。
        int len1 = str1.length();
        int len2 = str2.length();
        //建立上面说的数组，比字符长度大一个空间
        int[][] dif = new int[len1 + 1][len2 + 1];
        //赋初值，步骤B。
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        //计算两个字符是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                //取三个值中最小的
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1, dif[i - 1][j] + 1);
            }
        }
//        System.out.println("   " + str1 + "\"  与   \"   " + str2 + "   \"的比较");
        //取数组右下角的值，同样不同位置代表不同字符串的比较
//        System.out.println("差异步骤：" + dif[len1][len2]);
        //计算相似度
        float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        return similarity;
//        System.out.println("相似度："+getPercentValue(similarity));
    }

    public String getPercentValue(float similarity) {
        NumberFormat fmt = NumberFormat.getPercentInstance();
        fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
        return fmt.format(similarity);
    }

    //得到最小值
    private int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

}
