package com.lzlg.tool.util;

/**
 * 命令生成工具类
 *
 * @author lzlg
 */
public class CMDStatementUtils {

    private CMDStatementUtils() {
    }

    /**
     * windows环境下调用maven命令
     */
    public static String mvn(String localPath) {
        return "cmd /c mvn clean package -f " + localPath;
    }
}