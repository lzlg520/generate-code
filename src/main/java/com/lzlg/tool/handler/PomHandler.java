package com.lzlg.tool.handler;

import com.lzlg.tool.bean.RequestParam;
import com.lzlg.tool.config.Constant;
import com.lzlg.tool.util.ResourceUtil;
import com.lzlg.tool.util.TemplateTypeEnum;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 配置文件
 *
 * @author lzlg
 * 2020/3/14 21:00
 */
public class PomHandler {

    /**
     * 根据请求的数据生成配置文件
     */
    public void generate(RequestParam param) {
        try {
            Template template = ResourceUtil.getTemplate(TemplateTypeEnum.pom);
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, param);
            IOUtils.write(content, new FileOutputStream(new File("dist/" + Constant.pom)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
