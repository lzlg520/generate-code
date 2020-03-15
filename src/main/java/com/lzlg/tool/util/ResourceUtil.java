package com.lzlg.tool.util;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

/**
 * 资源工具类
 *
 * @author lzlg
 * 2020/3/14 11:19
 */
public class ResourceUtil {
    private ResourceUtil() {
    }

    private static final String templateName = "template";

    private static final ClassLoader loader = ResourceUtil.class.getClassLoader();

    /**
     * 根据模板类型获取模板信息
     */
    public static Template getTemplate(TemplateTypeEnum typeEnum) throws Exception {
        String typeName = typeEnum.getName();
        // 获取模板文件的输入流，并转换成String
        InputStream is = loader.getResourceAsStream("templates/" + typeName + ".ftl");
        String content = IOUtils.toString(is, "utf-8");
        is.close();
        // 模板配置
        Configuration configuration = new Configuration(Configuration.getVersion());
        StringTemplateLoader loader = new StringTemplateLoader();
        loader.putTemplate(templateName, content);
        configuration.setTemplateLoader(loader);
        return configuration.getTemplate(templateName);
    }
}
