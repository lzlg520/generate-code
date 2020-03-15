package com.lzlg.tool.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 控制器模型数据
 *
 * @author lzlg
 * 2020/3/14 13:02
 */
@Data
@ToString
@NoArgsConstructor
public class BeanModel implements Serializable {

    private String groupId;

    private String artifactId;
    // 表名 user_info
    private String tableName;
    // 驼峰命名 userInfo
    private String camelCaseName;
    // 首字母大写 UserInfo
    private String firstUpperName;
    // 主键
    private String primaryKey;
    // 主键类型
    private String primaryKeyType;
    // 请求路径
    private String path;

    private List<ColumnModel> columnModelList;

}
