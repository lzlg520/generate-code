package com.lzlg.tool.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库字段类型转Java类型
 *
 * @author lzlg
 * 2020/3/14 23:52
 */
public class TypeTransferUtil {
    private TypeTransferUtil() {
    }

    private static Map<String, String> typeMap = new HashMap<>();

    static {
        typeMap.put("INT", "Integer");
        typeMap.put("INT UNSIGNED", "Integer");
        typeMap.put("BIGINT", "Long");
        typeMap.put("DECIMAL", "BigDecimal");
        typeMap.put("CHAR", "String");
        typeMap.put("VARCHAR", "String");
        typeMap.put("TEXT", "String");
        typeMap.put("DATETIME", "Date");
        typeMap.put("BIT", "Boolean");
    }

    /**
     * 数据库字段类型转Java类型
     */
    public static String transfer(String dbType) {
        if (StringUtils.isEmpty(dbType)) {
            return null;
        }
        return typeMap.get(dbType);
    }
}
