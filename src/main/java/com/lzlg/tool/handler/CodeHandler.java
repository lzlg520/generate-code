package com.lzlg.tool.handler;

import com.lzlg.tool.config.Constant;
import com.lzlg.tool.model.BeanModel;
import com.lzlg.tool.util.TemplateTypeEnum;

/**
 * 代码生成
 *
 * @author lzlg
 * 2020/3/14 21:43
 */
public class CodeHandler extends GenerateHandler {

    /**
     * 生成所有有关的文件
     */
    public void generate(BeanModel model) {
        // 生成Entity文件
        generate(model, TemplateTypeEnum.bean, model.getFirstUpperName() + Constant.java);
        // 生成Controller文件
        generate(model, TemplateTypeEnum.controller, model.getFirstUpperName() +
                Constant.controller + Constant.java);
        // 生成Mapper文件
        generate(model, TemplateTypeEnum.mapper, model.getFirstUpperName() +
                Constant.mapper + Constant.java);
        // 生成Service文件
        generate(model, TemplateTypeEnum.service, model.getFirstUpperName() +
                Constant.service + Constant.java);
        // 生成ServiceImpl文件
        generate(model, TemplateTypeEnum.service_impl, model.getFirstUpperName() +
                Constant.service_impl + Constant.java);
        // 生成Mapper XML文件
        generate(model, TemplateTypeEnum.mapper_xml, model.getFirstUpperName() +
                Constant.mapper + Constant.xml);
        // 生成启动主类件
        generate(model, TemplateTypeEnum.application, model.getFirstUpperArtifact()
                + Constant.application + Constant.java);
    }
}
