package com.lzlg.tool;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lzlg
 * 2020/3/14 10:15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GenerateCodeTest {

    // 测试模板结合Model生成响应文件
    @Test
    public void test() throws Exception {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("templates/java/controller.ftl");
        String templateName = "template";
        Configuration configuration = new Configuration(Configuration.getVersion());
        StringTemplateLoader loader = new StringTemplateLoader();
        String content = IOUtils.toString(is, "utf-8");
        loader.putTemplate(templateName, content);
        configuration.setTemplateLoader(loader);

        Template template = configuration.getTemplate(templateName);

        Map<String, Object> model = new HashMap<>();
        model.put("packageName", "com.lzlg.tool");
        model.put("requestPath", "/generate/code");

        String s = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        System.out.println(s);

        IOUtils.write(s, new FileOutputStream(new File("Controller.java")));
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 测试JdbcTemplate
    @Test
    public void testJdbcTemplate() throws Exception {
        // 获取数据库元信息
        DatabaseMetaData databaseMetaData = jdbcTemplate.getDataSource().getConnection().getMetaData();

        String[] types = {"TABLE"};
        // 获取表集合
        ResultSet tables = databaseMetaData.getTables(null, null, null, types);
        while (tables.next()) {
            // 获取表名称
            String tableName = tables.getString("TABLE_NAME");

            // 获取表的主键信息
            ResultSet primaryKeys = databaseMetaData.getPrimaryKeys(null, null, tableName);
            while (primaryKeys.next()) {
                String primary = primaryKeys.getString("COLUMN_NAME");
                System.out.println(primary);
            }

            // 获取列集合
            ResultSet resultSet = databaseMetaData.getColumns(null, null, tableName, null);
            while (resultSet.next()) {
                System.out.println("=============================");
                // 获取列名
                String name = resultSet.getString("COLUMN_NAME");
                System.out.println(name);
                // 获取类型名
                String type = resultSet.getString("TYPE_NAME");
                System.out.println(type);
                // 获取注释
                String remarks = resultSet.getString("REMARKS");
                System.out.println(remarks);
                // 获取字段类型的长度
                int size = resultSet.getInt("COLUMN_SIZE");
                System.out.println(size);
            }
        }
    }

}
