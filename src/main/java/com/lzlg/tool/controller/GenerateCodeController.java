package com.lzlg.tool.controller;

import com.lzlg.tool.bean.RequestData;
import com.lzlg.tool.config.Constant;
import com.lzlg.tool.service.GenerateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @author lzlg
 * 2020/3/14 15:08
 */
@Controller
public class GenerateCodeController {

    @Autowired
    GenerateCodeService generateCodeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 生成项目zip包
     */
    @GetMapping("/generate/code")
    public void generateCode(@Valid RequestData requestData, HttpServletResponse response) {
        generateCodeService.generateCode(requestData);
        download(response, requestData.getArtifactId() + ".zip", "");
    }

    /**
     * 生成直接可运行的jar包
     */
    @GetMapping("/generate/jar")
    public void generateJar(@Valid RequestData requestData, HttpServletResponse response) {
        generateCodeService.generateJar(requestData);
        download(response, requestData.getArtifactId() + ".jar",
                requestData.getArtifactId() + File.separator + "target");
    }

    /**
     * 文件下载方法
     */
    private void download(HttpServletResponse response, String fileName, String parent) {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        File file = new File(Constant.dist + File.separator + parent + File.separator + fileName);
        response.setContentLength((int) file.length());
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            OutputStream os = response.getOutputStream();
            byte[] bytes = new byte[2048];
            int r;
            while ((r = bis.read(bytes)) != -1) {
                os.write(bytes, 0, r);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
