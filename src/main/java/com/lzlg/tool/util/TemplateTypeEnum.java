package com.lzlg.tool.util;

/**
 * 模板类型枚举类
 *
 * @author lzlg
 * 2020/3/14 11:24
 */
public enum TemplateTypeEnum {
    // 实体类
    bean("java/bean"),
    // 控制器类
    controller("java/controller"),
    // Mapper接口
    mapper("java/mapper"),
    // Mapper XML文件
    mapper_xml("xml/mapper_xml"),
    // 服务接口
    service("java/service"),
    // 服务接口实现类
    service_impl("java/service_impl"),
    // yaml配置文件
    configuration("yaml/configuration"),
    // Pom文件
    pom("xml/pom"),
    // 启动类
    application("java/application");

    private String name;

    TemplateTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
