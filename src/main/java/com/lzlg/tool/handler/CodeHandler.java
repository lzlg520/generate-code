package com.lzlg.tool.handler;

import com.lzlg.tool.config.Constant;
import com.lzlg.tool.handler.dir.DirectoryHandler;
import com.lzlg.tool.model.BeanModel;
import com.lzlg.tool.util.TemplateTypeEnum;

import java.io.File;

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
        generate(model, TemplateTypeEnum.bean, DirectoryHandler.getPath(TemplateTypeEnum.bean)
                + File.separator + model.getFirstUpperName() + Constant.java);
        // 生成Controller文件
        generate(model, TemplateTypeEnum.controller, DirectoryHandler.getPath(TemplateTypeEnum.controller)
                + File.separator + model.getFirstUpperName() +
                Constant.controller + Constant.java);
        // 生成Mapper文件
        generate(model, TemplateTypeEnum.mapper, DirectoryHandler.getPath(TemplateTypeEnum.mapper)
                + File.separator + model.getFirstUpperName() +
                Constant.mapper + Constant.java);
        // 生成Service文件
        generate(model, TemplateTypeEnum.service, DirectoryHandler.getPath(TemplateTypeEnum.service)
                + File.separator + model.getFirstUpperName() +
                Constant.service + Constant.java);
        // 生成ServiceImpl文件
        generate(model, TemplateTypeEnum.service_impl, DirectoryHandler.getPath(TemplateTypeEnum.service_impl)
                + File.separator + model.getFirstUpperName() +
                Constant.service_impl + Constant.java);
        // 生成Mapper XML文件
        generate(model, TemplateTypeEnum.mapper_xml, DirectoryHandler.getPath(TemplateTypeEnum.mapper_xml)
                + File.separator + model.getFirstUpperName() +
                Constant.mapper + Constant.xml);
        // 生成启动主类件
        generate(model, TemplateTypeEnum.application, DirectoryHandler.getPath(TemplateTypeEnum.application)
                + File.separator + model.getFirstUpperArtifact()
                + Constant.application + Constant.java);
        // 清理存储路径的Map
        DirectoryHandler.clean();
    }
}
