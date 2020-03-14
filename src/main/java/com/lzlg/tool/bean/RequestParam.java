package com.lzlg.tool.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 请求参数
 *
 * @author lzlg
 * 2020/3/14 15:17
 */
@Data
@ToString
@NoArgsConstructor
public class RequestParam {

    @NotBlank
    private String groupId;

    @NotBlank
    private String artifactId;

    @NotNull
    private DatabaseInfo databaseInfo;
}
