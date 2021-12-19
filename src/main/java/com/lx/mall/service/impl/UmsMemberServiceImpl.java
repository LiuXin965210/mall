package com.lx.mall.service.impl;

import com.lx.mall.api.CommonResult;
import com.lx.mall.service.RedisService;
import com.lx.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * 会员管理业务实现类
 *
 * @author LiuXin
 * @date 2021/12/19 19:00
 **/
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Resource
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        String actualCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if(authCode.equals(actualCode)) {
            return CommonResult.success(null, "验证码校验成功");
        }
        return CommonResult.failed("验证码不正确");
    }
}
