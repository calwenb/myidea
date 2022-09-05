package com.wen.backresult.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {
    private Integer code;
    private T data;
    private String message;
    private Boolean success;
    private DataError dataError;
}
