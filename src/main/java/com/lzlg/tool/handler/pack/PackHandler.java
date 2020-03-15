package com.lzlg.tool.handler.pack;

import com.lzlg.tool.config.Constant;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 将项目打成zip文件夹
 *
 * @author lzlg
 * 2020/3/15 16:21
 */
public class PackHandler {
    /**
     * 把项目打包成zip
     */
    public void pack(String project) {
        // 项目目录
        String projectPath = Constant.dist + File.separator + project;
        // 目标文件
        String zipPath = Constant.dist + File.separator + project + ".zip";
        File sourceFile = new File(projectPath);
        File zipFile = new File(zipPath);
        if (zipFile.exists()) {
            zipFile.delete();
        }
        byte[] bytes = new byte[1024 * 10];
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            pack(zos, sourceFile, sourceFile.getName(), bytes);
            // 打包完成后删除原来的文件夹
            if (sourceFile.exists()) {
                sourceFile.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归打包，并保存原来的目录结构
     */
    private void pack(ZipOutputStream zos, File sourceFile, String name, byte[] bytes) throws Exception {
        BufferedInputStream bis;
        if (sourceFile.isFile()) {
            bis = new BufferedInputStream(new FileInputStream(sourceFile));
            zos.putNextEntry(new ZipEntry(name));
            int read;
            while ((read = bis.read(bytes)) != -1) {
                zos.write(bytes, 0, read);
            }
            bis.close();
        } else {
            File[] fileArray = sourceFile.listFiles();
            if (fileArray == null || fileArray.length == 0) {
                zos.putNextEntry(new ZipEntry(name + File.separator));
            } else {
                for (File file : fileArray) {
                    pack(zos, file, name + File.separator + file.getName(), bytes);
                }
            }
        }
    }
}
