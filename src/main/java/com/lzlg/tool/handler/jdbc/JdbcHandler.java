package com.lzlg.tool.handler.jdbc;

import com.lzlg.tool.bean.RequestData;
import com.lzlg.tool.model.BeanModel;
import com.lzlg.tool.model.ColumnModel;
import com.lzlg.tool.util.NamingRuleUtil;
import com.lzlg.tool.util.TypeTransferUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * jdbc连接
 *
 * @author lzlg
 * 2020/3/14 20:35
 */
public class JdbcHandler {

    private static final String mysql_driver = "com.mysql.jdbc.Driver";

    /**
     * 获取数据库元数据集合
     */
    public List<BeanModel> getBeanModelList(RequestData param) {
        List<BeanModel> list = new ArrayList<>();
        // 获取数据库连接
        Connection connection = null;
        try {
            connection = getConnection(param);
            // 获取数据库元信息
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            String[] types = {"TABLE"};
            // 获取表集合
            ResultSet tables = databaseMetaData.getTables(null, null, null, types);
            while (tables.next()) {
                BeanModel beanModel = new BeanModel();
                beanModel.setGroupId(param.getGroupId());
                String artifactId = param.getArtifactId();
                beanModel.setArtifactId(artifactId);
                beanModel.setFirstUpperArtifact(NamingRuleUtil.middleToCamelCase(artifactId));
                beanModel.setPackageName(NamingRuleUtil.toPackage(artifactId));

                // 获取表名称
                String tableName = tables.getString("TABLE_NAME");
                beanModel.setTableName(tableName);
                String camelCaseName = NamingRuleUtil.underlineToCamelCase(tableName);
                beanModel.setCamelCaseName(camelCaseName);
                beanModel.setFirstUpperName(NamingRuleUtil.toFirstUpper(camelCaseName));
                beanModel.setPath(NamingRuleUtil.toPath(tableName));

                // 获取表的主键信息
                ResultSet primaryKeys = databaseMetaData.getPrimaryKeys(null, null, tableName);
                while (primaryKeys.next()) {
                    String primary = primaryKeys.getString("COLUMN_NAME");
                    beanModel.setPrimaryKey(primary);
                }

                // 获取列集合
                ResultSet resultSet = databaseMetaData.getColumns(null, null, tableName, null);
                List<ColumnModel> columnModelList = new ArrayList<>();
                while (resultSet.next()) {
                    ColumnModel columnModel = new ColumnModel();
                    // 获取列名
                    String name = resultSet.getString("COLUMN_NAME");
                    columnModel.setName(name);
                    columnModel.setCamelCaseName(NamingRuleUtil.underlineToCamelCase(name));
                    // 获取类型名
                    String type = resultSet.getString("TYPE_NAME");
                    System.out.println(type);
                    String javaType = TypeTransferUtil.transfer(type);
                    columnModel.setType(javaType);
                    // 如果列名等于主键名，则记录主键类型
                    if (name.equals(beanModel.getPrimaryKey())) {
                        beanModel.setPrimaryKeyType(javaType);
                    }
                    // 获取注释
                    String remarks = resultSet.getString("REMARKS");
                    columnModel.setRemarks(remarks);
                    // 添加到集合中
                    columnModelList.add(columnModel);
                }

                beanModel.setColumnModelList(columnModelList);
                list.add(beanModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            close(connection);
        }
    }

    /**
     * 根据数据库信息获取数据库连接
     */
    private Connection getConnection(RequestData param) throws Exception {
        // 加载驱动
        Class.forName(mysql_driver);
        // 创建连接
        return DriverManager.getConnection(param.getUrl(), param.getUsername(), param.getPassword());
    }

    /**
     * 关闭数据库连接
     */
    private void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
