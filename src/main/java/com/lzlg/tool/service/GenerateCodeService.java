package com.lzlg.tool.service;

import com.lzlg.tool.bean.RequestParam;
import com.lzlg.tool.handler.CodeHandler;
import com.lzlg.tool.handler.ConfigurationHandler;
import com.lzlg.tool.handler.PomHandler;
import com.lzlg.tool.handler.dir.DirectoryHandler;
import com.lzlg.tool.handler.jdbc.JdbcHandler;
import com.lzlg.tool.model.BeanModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目生成服务类
 *
 * @author lzlg
 * 2020/3/14 15:14
 */
@Service
public class GenerateCodeService {

    /**
     * 生成项目并打包成zip
     */
    public void generateCode(RequestParam param) {
        // 生成工程目录
        DirectoryHandler directoryHandler = new DirectoryHandler();
        directoryHandler.makeDirs(param);

        // 生成spring boot工程配置文件
        ConfigurationHandler configurationHandler = new ConfigurationHandler();
        configurationHandler.generate(param);

        // 生成项目pom.xml
        PomHandler pomHandler = new PomHandler();
        pomHandler.generate(param);

        // TODO 1.获取数据库元信息，并组装成Bean
        // 获取数据库表元数据
        JdbcHandler jdbcHandler = new JdbcHandler();
        List<BeanModel> beanModelList = jdbcHandler.getBeanModelList(param);

        // TODO 2.将获取到的Bean信息，利用Freemarker和模板文件渲染成相应的文件到项目下的dist文件夹下
        CodeHandler codeHandler = new CodeHandler();
        for (BeanModel beanModel : beanModelList) {
            codeHandler.generate(beanModel);
        }
        // TODO 3.打包dist文件夹为zip，返回前端
    }
}
