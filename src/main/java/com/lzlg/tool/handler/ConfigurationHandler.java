package com.lzlg.tool.handler;

import com.lzlg.tool.bean.RequestParam;
import com.lzlg.tool.config.Constant;
import com.lzlg.tool.util.TemplateTypeEnum;

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
        generate(param, TemplateTypeEnum.configuration, Constant.configuration);
    }
}
