package com.calwen.httpcodegenerate;

import com.calwen.httpcodegenerate.util.StringUtil;
import org.junit.jupiter.api.Test;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/9/9
 */
public class StringTest {
    @Test
    void t1() {
        StringBuilder sb = new StringBuilder();
        long sTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            StringUtil.append(sb, "name=%s age=%s ", "wen", "12");
        }
        System.out.println(" StringUtil 耗时：" + (System.currentTimeMillis() - sTime));
//        System.out.println(sb);


        sb = new StringBuilder();
        sTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(String.format("name=%s age=%s ", "wen", "12"));
        }
        System.out.println(" format 耗时：" + (System.currentTimeMillis() - sTime));
//        System.out.println(sb);

        sb = new StringBuilder();
        sTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("name=").append("wen").append(" age=").append("12 ");
        }
        System.out.println(" format 耗时：" + (System.currentTimeMillis() - sTime));
//        System.out.println(sb);
    }

}
