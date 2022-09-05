package com.wen.backresult.util;


import com.wen.backresult.enums.ResultEnum;
import com.wen.backresult.vo.DataError;
import com.wen.backresult.vo.ResultVO;

/**
 * 统一返回体
 * 使用时建议继承扩展
 *
 * @author calwen
 * @since 2022/7/20
 */
public class ResultUtil {

    public static <T> ResultVO<T> success() {
        return buildSuccessVO(null, ResultEnum.SUCCESS.getMessage());
    }

    public static <T> ResultVO<T> success(T data) {
        return buildSuccessVO(data, ResultEnum.SUCCESS.getMessage());
    }

    public static <T> ResultVO<T> success(T data, String msg) {
        return buildSuccessVO(data, msg);
    }

    public static <T> ResultVO<T> successMsg(String msg) {
        return buildSuccessVO(null, msg);
    }

    public static ResultVO<Object> error() {
        return buildErrorVO(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage());
    }

    public static ResultVO<Object> error(String msg) {
        return buildErrorVO(ResultEnum.ERROR.getCode(), msg);
    }


    public static ResultVO<Object> exception() {
        return buildErrorVO(ResultEnum.EXCEPTION.getCode(), ResultEnum.EXCEPTION.getMessage());
    }

    public static ResultVO<Object> exception(String msg) {
        return buildErrorVO(ResultEnum.EXCEPTION.getCode(), ResultEnum.EXCEPTION.getMessage() + msg);
    }

    public static ResultVO<Object> exception(String domain, String exception, String message) {
        DataError dataError = DataError.builder()
                .domain(domain)
                .exception(exception)
                .message(message)
                .build();
        return buildErrorVO(ResultEnum.EXCEPTION.getCode(), null, dataError);
    }


    public static ResultVO<Object> badRequest() {
        return buildErrorVO(ResultEnum.BAD_REQUEST.getCode(), ResultEnum.BAD_REQUEST.getMessage());
    }

    public static ResultVO<Object> badRequest(String msg) {
        return buildErrorVO(ResultEnum.BAD_REQUEST.getCode(), msg);
    }

    public static ResultVO<Object> unauthorized() {
        return buildErrorVO(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMessage());
    }

    public static ResultVO<Object> unauthorized(String msg) {
        return buildErrorVO(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMessage());
    }

    private static <T> ResultVO<T> buildSuccessVO(T data, String msg) {
        return ResultVO.<T>builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(msg)
                .data(data)
                .success(true)
                .build();
    }

    private static ResultVO<Object> buildErrorVO(Integer code, String msg) {
        return ResultVO.builder()
                .code(code)
                .message(msg)
                .data(null)
                .success(false)
                .build();
    }

    private static ResultVO<Object> buildErrorVO(Integer code, String msg, DataError dataError) {
        return ResultVO.builder()
                .code(code)
                .message(msg)
                .data(null)
                .success(false)
                .dataError(dataError)
                .build();
    }

}
