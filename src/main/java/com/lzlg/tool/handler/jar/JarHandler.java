package com.lzlg.tool.handler.jar;

import com.lzlg.tool.util.CMDStatementUtils;

import java.io.IOException;

/**
 * 生成jar包
 *
 * @author lzlg
 * 2020/3/15 18:40
 */
public class JarHandler {

    private final Runtime runtime = Runtime.getRuntime();

    /**
     * 运行Maven命令打成jar包
     */
    public void getJar(String path) {
        String command = CMDStatementUtils.mvn(path);
        try {
            Process exec = runtime.exec(command);
            while (exec.isAlive()) {
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
