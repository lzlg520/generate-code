package com.lzlg.tool.util;

import org.springframework.util.StringUtils;

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

    /**
     * 下划线转驼峰命名
     */
    public static String toCamelCase(String underline) {
        if (StringUtils.isEmpty(underline)) {
            return null;
        }
        // 无下划线，不需要转换
        if (!underline.contains(UNDERLINE)) {
            return underline;
        }
        String[] split = underline.split(UNDERLINE);
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            sb.append(toFirstUpper(split[i]));
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
        if (StringUtils.isEmpty(underline)) {
            return null;
        }
        // 无下划线，不需要转换
        if (!underline.contains(UNDERLINE)) {
            return underline;
        }
        return underline.replaceAll("_", "/");
    }

}
