package com.lzlg.tool.controller;

import com.lzlg.tool.bean.RequestParam;
import com.lzlg.tool.service.GenerateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

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

    @PostMapping("/generate/code")
    public void generateCode(@RequestBody RequestParam requestParam, HttpServletResponse response) {
        generateCodeService.generateCode(requestParam);
        
//        response.setContentType("application/x-zip-compressed;charset=UTF-8");
//        response.setHeader("Content-Disposition", "attachment;filename=test.zip");
//        try (ServletOutputStream os = response.getOutputStream()) {
//            os.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
