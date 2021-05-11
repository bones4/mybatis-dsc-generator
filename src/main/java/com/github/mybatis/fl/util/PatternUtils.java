package com.github.mybatis.fl.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: zhangwei
 * @CreateDate: 2020/3/14 18:10
 */
public class PatternUtils {
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /** 下划线转驼峰 */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

//    /** 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)}) */
//    public static String humpToLine(String str) {
//        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
//    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /** 驼峰转下划线,效率比上面高 */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String lineToHump = lineToHump("f_parent_no_leader");
        System.out.println(lineToHump);// fParentNoLeader
       // System.out.println(humpToLine(lineToHump));// f_parent_no_leader
        System.out.println(humpToLine(lineToHump));// f_parent_no_leader
        System.out.println(PatternUtils.humpToLine("f_parent_no_leader"));

    }

}
