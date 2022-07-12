package com.wen.backresult.util;

import com.wen.backresult.vo.Result;

public class ResultUtil {


    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode())
                .setMessage("success")
                .setData(data);
        return result;
    }

    public static Result<String> error(String message) {
        Result<String> result = new Result<>();
        result.setCode(ResultEnum.ERROR.getCode())
                .setMessage(message)
                .setData(null);
        return result;
    }

    public static Result<String> unauthorized() {
        Result<String> result = new Result<>();
        result.setCode(ResultEnum.UNAUTHORIZED.getCode())
                .setMessage("验证失败,无权访问！")
                .setData(null);
        return result;
    }

    public static Result<String> badRequest() {
        Result<String> result = new Result<>();
        result.setCode(ResultEnum.BAD_REQUEST.getCode())
                .setMessage("错误请求，请联系管理员！")
                .setData(null);
        return result;
    }

}
