package com.lzlg.tool.handler.dir;

import com.lzlg.tool.bean.RequestParam;
import com.lzlg.tool.config.Constant;
import com.lzlg.tool.util.NamingRuleUtil;
import com.lzlg.tool.util.TemplateTypeEnum;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 工程目录生成
 *
 * @author lzlg
 * 2020/3/15 12:32
 */
public class DirectoryHandler {

    private static Map<TemplateTypeEnum, String> pathMap = new HashMap<>();

    /**
     * 生成目录
     */
    public void makeDirs(RequestParam param) {
        String groupPath = NamingRuleUtil.toGroupPath(param.getGroupId());

        String artifactId = param.getArtifactId();
        String basePackage = NamingRuleUtil.toPackage(artifactId);

        // ========项目根路径=========
        String projectRoot = Constant.dist + File.separator + artifactId
                + File.separator + "src";
        // =========项目代码路径===========
        // main
        String mainRoot = projectRoot + File.separator + "main";

        // main--java
        String artifactPath = mainRoot + File.separator + "java"
                + File.separator + groupPath + File.separator + basePackage;
        makeDirs(artifactPath);

        String entityPath = artifactPath + File.separator + "entity";
        makeDirs(entityPath);
        pathMap.put(TemplateTypeEnum.bean, entityPath);

        String mapperPath = artifactPath + File.separator + "mapper";
        makeDirs(mapperPath);
        pathMap.put(TemplateTypeEnum.mapper, mapperPath);

        String servicePath = artifactPath + File.separator + "service";
        makeDirs(servicePath);
        pathMap.put(TemplateTypeEnum.service, servicePath);

        String serviceImplPath = servicePath + File.separator + "impl";
        makeDirs(serviceImplPath);
        pathMap.put(TemplateTypeEnum.service_impl, serviceImplPath);

        String controllerPath = artifactPath + File.separator + "controller";
        makeDirs(controllerPath);
        pathMap.put(TemplateTypeEnum.controller, controllerPath);

        // main--resources
        String resources = mainRoot + File.separator + "resources";
        makeDirs(resources);

        String mapperXml = resources + File.separator + "mapper";
        makeDirs(mapperXml);

        // =========测试路径，可有可无========
        String testRoot = projectRoot + File.separator + "test";
        makeDirs(testRoot + File.separator + "java"
                + File.separator + groupPath + File.separator + basePackage);

        // ============设置文件存放路径=========
        pathMap.put(TemplateTypeEnum.pom, Constant.dist + File.separator + artifactId);
        pathMap.put(TemplateTypeEnum.configuration, resources);
        pathMap.put(TemplateTypeEnum.mapper_xml, mapperXml);
        pathMap.put(TemplateTypeEnum.application, artifactPath);
    }

    /**
     * 创建目录
     */
    private void makeDirs(String path) {
        File testFile = new File(path);
        if (!testFile.exists()) {
            testFile.mkdirs();
        }
    }

    /**
     * 根据文件类型获取存放路径
     */
    public static String getPath(TemplateTypeEnum typeEnum) {
        if (pathMap.isEmpty()) {
            return null;
        }
        return pathMap.get(typeEnum);
    }

    public static void clean() {
        pathMap.clear();
    }
}
