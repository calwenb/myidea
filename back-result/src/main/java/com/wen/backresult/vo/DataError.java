package com.wen.backresult.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误数据类
 *
 * @author calwen
 * @since 2022/9/5
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataError {
    /**
     * 应用名
     */
    private String domain;
    /**
     * 异常类名
     */
    private String exception;
    /**
     * 异常消息
     */
    private String message;
}
