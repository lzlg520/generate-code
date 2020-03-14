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

    private String name;

    private String remarks;

}
