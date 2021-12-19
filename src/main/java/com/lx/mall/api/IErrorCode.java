package com.lx.mall.api;

/**
 * API执行错误码接口
 * @author LiuXin
 * @date 2021/12/12 22:15
 **/
public interface IErrorCode {
    /**
     * API执行返回码
     * @author LiuXin
     * @date 2021/12/12 22:39
     * @return long
     */
    long getCode();

    /**
     * API执行返回信息
     * @author LiuXin
     * @date 2021/12/12 22:39
     * @return java.lang.String
     */
    String getMessage();
}
