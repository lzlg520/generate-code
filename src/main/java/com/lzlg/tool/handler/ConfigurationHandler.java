package com.lzlg.tool.handler;

import com.lzlg.tool.bean.RequestParam;
import com.lzlg.tool.config.Constant;
import com.lzlg.tool.handler.dir.DirectoryHandler;
import com.lzlg.tool.util.TemplateTypeEnum;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 配置文件
 *
 * @author lzlg
 * 2020/3/14 21:00
 */
public class ConfigurationHandler extends GenerateHandler {

    /**
     * 根据请求的数据生成配置文件
     */
    public void generate(RequestParam param) {
        String path = DirectoryHandler.getPath(TemplateTypeEnum.configuration);
        // 把日志配置文件放入项目中
        String logback = "logback-spring.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(logback);
        try {
            IOUtils.copy(is, new FileOutputStream(new File(path + File.separator + logback)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        generate(param, TemplateTypeEnum.configuration, path + File.separator + Constant.configuration);
    }
}
