package com.lzlg.tool.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 请求参数
 *
 * @author lzlg
 * 2020/3/14 15:17
 */
@Data
@ToString
@NoArgsConstructor
public class RequestData implements Serializable {

    @NotBlank
    private String groupId;

    @NotBlank
    private String artifactId;

    @NotBlank
    private String url;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
