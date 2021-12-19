package com.lx.mall.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * API共通返回值
 * @author LiuXin
 * @date 2021/12/12 22:15
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    /**
     * 状态码
     */
    private long code;

    /**
     * 提示信息
     */
    private String message;
    
    /**
     * 数据封装
     */
    private T data;

    /**
     * API执行成功返回结果
     * @author LiuXin
     * @date 2021/12/12 22:24
     * @param data
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * API执行成功返回结果
     * @author LiuXin
     * @date 2021/12/19 19:10
     * @param data 
     * @param message 
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * API执行失败返回结果
     * @author LiuXin
     * @date 2021/12/12 22:24
     * @param errorCode
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * API执行失败返回结果
     * @author LiuXin
     * @date 2021/12/12 22:24
     * @param errorCode
     * @param message
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode, String message) {
        return new CommonResult<>(errorCode.getCode(), message, null);
    }

    /**
     * API执行失败返回结果
     * @author LiuXin
     * @date 2021/12/12 22:25
     * @param message
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * API执行失败返回结果
     * @author LiuXin
     * @date 2021/12/12 22:26
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * API参数验证失败返回结果
     * @author LiuXin
     * @date 2021/12/12 22:28
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * API参数验证失败返回结果
     * @author LiuXin
     * @date 2021/12/12 22:29
     * @param message
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * API执行时未登录返回结果
     * @author LiuXin
     * @date 2021/12/12 22:30
     * @param data
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * API执行权限不足返回结果
     * @author LiuXin
     * @date 2021/12/12 22:29
     * @param data
     * @return com.lx.mall.api.CommonResult<T>
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}
