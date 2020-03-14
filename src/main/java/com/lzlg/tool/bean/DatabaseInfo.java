package com.lzlg.tool.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author lzlg
 * 2020/3/14 15:19
 */
@Data
@ToString
@NoArgsConstructor
public class DatabaseInfo {

    @NotBlank
    private String url;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
