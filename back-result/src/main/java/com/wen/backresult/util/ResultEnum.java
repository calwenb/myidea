package com.wen.backresult.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    /**
     * 成功响应码
     */
    SUCCESS(200),

    /**
     * 失败响应码
     */
    ERROR(500),

    /**
     * 验证失败响应码
     */
    UNAUTHORIZED(401),

    /**
     * 错误的请求响应码
     */
    BAD_REQUEST(400);


    private final Integer code;

}
