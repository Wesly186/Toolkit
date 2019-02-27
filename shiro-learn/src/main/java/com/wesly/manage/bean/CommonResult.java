package com.wesly.manage.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {

    private int code;
    private String message;
    private Object data;

    public static CommonResult resultOK(String message, Object data) {
        return new CommonResult(200, message, data);
    }

    public static CommonResult resultError(int code, String message) {
        return new CommonResult(code, message, null);
    }
}