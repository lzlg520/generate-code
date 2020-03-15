package com.lzlg.tool.handler.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理异常
 *
 * @author lzlg
 * 2020/3/14 15:35
 */
@ControllerAdvice
public class ExceptionCatch {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handle(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "500");
        map.put("message", e.getMessage());
        return map;
    }
}
