package com.lzlg.tool.handler;

import com.lzlg.tool.bean.RequestData;
import com.lzlg.tool.config.Constant;
import com.lzlg.tool.handler.dir.DirectoryHandler;
import com.lzlg.tool.util.TemplateTypeEnum;

import java.io.File;

/**
 * 配置文件
 *
 * @author lzlg
 * 2020/3/14 21:00
 */
public class PomHandler extends GenerateHandler {

    /**
     * 根据请求的数据生成配置文件
     */
    public void generate(RequestData param) {
        generate(param, TemplateTypeEnum.pom, DirectoryHandler.getPath(TemplateTypeEnum.pom)
                + File.separator + Constant.pom);
    }
}
