package com.lx.mall.service.impl;

import com.lx.mall.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis业务实现类
 *
 * @author LiuXin
 * @date 2021/12/19 17:53
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private StringRedisTemplate template;

    @Override
    public void set(String key, String value) {
        template.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return Boolean.TRUE.equals(template.expire(key, expire, TimeUnit.SECONDS));
    }

    @Override
    public void remove(String key) {
        template.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return template.opsForValue().increment(key, delta);
    }
}
