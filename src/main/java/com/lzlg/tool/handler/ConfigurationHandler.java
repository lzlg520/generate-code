package com.lzlg.tool.handler;

import com.lzlg.tool.bean.RequestData;
import com.lzlg.tool.config.Constant;
import com.lzlg.tool.handler.dir.DirectoryHandler;
import com.lzlg.tool.util.TemplateTypeEnum;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
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
    public void generate(RequestData param) {
        String path = DirectoryHandler.getPath(TemplateTypeEnum.configuration);
        // 把日志配置文件放入项目中
        String logback = "logback-spring.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(logback);
        try {
            FileOutputStream fos = new FileOutputStream(new File(path + File.separator + logback));
            IOUtils.copy(is, fos);
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        generate(param, TemplateTypeEnum.configuration, path + File.separator + Constant.configuration);
    }
}
