package com.calwen.httpcodegenerate.util;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/9/9
 */
public class StringUtil {
    public static void append(StringBuilder sb, String format, Object... args) {
        int l = 0;
        int r;
        for (Object arg : args) {
            int i = format.indexOf("%s", l);
            sb.append(format, l, i);
            l = i;
            r = l + 2;
            sb.append(arg);
            l = r;
        }
        sb.append(format.substring(l));
    }
    public static void append(StringBuffer sb, String format, Object... args) {
        int l = 0;
        int r;
        for (Object arg : args) {
            int i = format.indexOf("%s", l);
            sb.append(format, l, i);
            l = i;
            r = l + 2;
            sb.append(arg);
            l = r;
        }
        sb.append(format.substring(l));
    }
}
