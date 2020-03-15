package com.lzlg.tool.handler;

import com.lzlg.tool.util.ResourceUtil;
import com.lzlg.tool.util.TemplateTypeEnum;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 通用方法
 *
 * @author lzlg
 * 2020/3/15 12:35
 */
public abstract class GenerateHandler {
    /**
     * 根据请求的数据生成Entity文件
     */
    protected void generate(Object model, TemplateTypeEnum typeEnum, String fileName) {
        try {
            Template template = ResourceUtil.getTemplate(typeEnum);
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            IOUtils.write(content, new FileOutputStream(new File("dist/" + fileName)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
