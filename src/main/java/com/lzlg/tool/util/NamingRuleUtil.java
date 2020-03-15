package com.lzlg.tool.util;

import org.springframework.util.StringUtils;

import java.io.File;

/**
 * 命名规则工具类
 *
 * @author lzlg
 * 2020/3/14 14:52
 */
public class NamingRuleUtil {
    private NamingRuleUtil() {
    }

    private static final String UNDERLINE = "_";

    private static final String MIDDLE = "-";

    /**
     * 下划线转驼峰命名
     */
    public static String underlineToCamelCase(String underline) {
        return toCamelCase(underline, UNDERLINE);
    }

    /**
     * 中划线转驼峰命名
     *
     * @return
     */
    public static String middleToCamelCase(String middle) {
        return toFirstUpper(toCamelCase(middle, MIDDLE));
    }

    /**
     * 转驼峰命名
     */
    private static String toCamelCase(String content, String split) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        // 无下划线，不需要转换
        if (!content.contains(split)) {
            return content;
        }
        String[] array = content.split(split);
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(toFirstUpper(array[i]));
        }
        return sb.toString();
    }


    /**
     * 驼峰命名首字母大写
     */
    public static String toFirstUpper(String content) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        char upperCase = Character.toUpperCase(content.charAt(0));
        return upperCase + content.substring(1);
    }

    /**
     * 把有多个下划线的单词转换成请求路径
     */
    public static String toPath(String underline) {
        return to(underline, UNDERLINE, "/");
    }

    /**
     * 把有多个中划线的单词转换成包名
     */
    public static String toPackage(String middle) {
        return to(middle, MIDDLE, UNDERLINE);
    }

    /**
     * 把groupId转换成路径名
     */
    public static String toGroupPath(String groupId) {
        if (StringUtils.isEmpty(groupId)) {
            return null;
        }
        // 无..，不需要转换
        if (!groupId.contains(".")) {
            return groupId;
        }
        return groupId.replace(".", File.separator);
    }

    /**
     * 单词转换
     */
    private static String to(String content, String regex, String replace) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        // 无下划线，不需要转换
        if (!content.contains(regex)) {
            return content;
        }
        return content.replaceAll(regex, replace);
    }
}
