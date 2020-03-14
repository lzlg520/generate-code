package com.lzlg.tool.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 基本模型数据类
 *
 * @author lzlg
 * 2020/3/14 13:03
 */
@Data
@ToString
@NoArgsConstructor
public class BaseModel implements Model {

    String groupId;

    String artifactId;
}
