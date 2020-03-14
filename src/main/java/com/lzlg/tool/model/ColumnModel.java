package com.lzlg.tool.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 列数据信息
 *
 * @author lzlg
 * 2020/3/14 20:17
 */
@Data
@ToString
@NoArgsConstructor
public class ColumnModel {

    private String type;
    // 列名 user_address
    private String name;
    // 驼峰命名 userAddress
    private String camelCaseName;

    private String remarks;

}
