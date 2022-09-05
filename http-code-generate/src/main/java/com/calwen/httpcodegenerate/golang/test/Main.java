package com.calwen.httpcodegenerate.golang.test;

import com.calwen.httpcodegenerate.golang.util.CodeGenerateToGoUtil;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/8/31
 */
public class Main {
    public static void main(String[] args) {
        CodeGenerateToGoUtil util = new CodeGenerateToGoUtil();
        String generate = util.generate();
        System.out.println(generate);

    }
}
