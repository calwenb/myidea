package com.calwen.httpcodegenerate.golang.util;

/**
 * @author calwen
 * @eamil calvinwen@dianhun.cn
 * @since 2022/8/31
 */
public class CodeGenerateToGoUtil {
    private String spliceHead() {
        return "package main\n" +
                "\n" +
                "import (\n" +
                "\t\"fmt\"\n" +
                "\t\"io/ioutil\"\n" +
                "\t\"log\"\n" +
                "\t\"net/http\"\n" +
                "\t\"strings\"\n" +
                ")\n" +
                "\n" +
                "func main() {\n" +
                "\tclient := &http.Client{}\n";
    }

    private String spliceTail() {
        return "\tresp, err := client.Do(req)\n" +
                "\tif err != nil {\n" +
                "\t\tlog.Fatal(err)\n" +
                "\t}\n" +
                "\tbodyText, err := ioutil.ReadAll(resp.Body)\n" +
                "\tif err != nil {\n" +
                "\t\tlog.Fatal(err)\n" +
                "\t}\n" +
                "\tfmt.Printf(\"%s\\n\", bodyText)\n" +
                "}\n";
    }

    private void spliceMain(StringBuilder sb) {
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append(spliceHead());
        spliceMain(sb);
        sb.append(spliceTail());
        return String.valueOf(sb);
    }
}
