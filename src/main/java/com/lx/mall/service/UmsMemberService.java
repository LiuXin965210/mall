package com.lx.mall.service;

import com.lx.mall.api.CommonResult;

/**
 * 用户验证接口类
 *
 * @author LiuXin
 * @date 2021/12/19 12:19
 **/
public interface UmsMemberService {
    /**
     * 生成验证码
     * @author LiuXin
     * @date 2021/12/19 18:59
     * @param telephone
     * @return com.lx.mall.api.CommonResult
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 校验验证码
     * @author LiuXin
     * @date 2021/12/19 18:59
     * @param telephone
     * @param authCode
     * @return com.lx.mall.api.CommonResult
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
