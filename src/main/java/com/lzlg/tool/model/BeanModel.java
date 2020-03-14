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
public class BeanModel extends BaseModel implements Serializable {

    private String tableName;

    private String primaryKey;

    private List<ColumnModel> columnModelList;

}
