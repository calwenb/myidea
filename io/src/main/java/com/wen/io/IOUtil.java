package com.wen.io;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author calwen
 * @since 2023/2/4
 */
public class IOUtil {
    //    private final String sourceDir = "C:\\Users\\Mr.wen\\Desktop\\tp\\文件夹\\源";
    private String targetDir = "D:\\wen\\文殿生\\生成";

    private final String sourceDir = "D:\\wen\\文殿生\\22财年兴宁班补标志牌";

    public void doing() {
        String name = sourceDir.substring(sourceDir.lastIndexOf("\\"));
        targetDir += "\\" + name;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> okList = new ArrayList<>();
//        List<String> ls = Arrays.stream(FileUtil.ls(sourceDir)).map(File::getPath).collect(Collectors.toList());
        File[] ls = FileUtil.ls(sourceDir);
        //遍历 文件夹
        for (File top : ls) {
            String topPath = top.toPath().toString();

            File[] twoFile = FileUtil.ls(topPath);
            boolean doed = false;
            for (File file : twoFile) {
                //有二级目录,代表已做完
                if (file.isDirectory()) {
                    okList.add(topPath);
                    doed = true;
                    break;
                }
            }
            if (Objects.equals(doed, false)) {
                list.add(top.getName());
            }
        }
        for (String p : okList) {
            FileUtil.copy(p, targetDir, true);
        }
        for (String p : list) {
            FileUtil.mkdir(String.format("%s\\%s\\照片", targetDir, p));
        }


    }

}
