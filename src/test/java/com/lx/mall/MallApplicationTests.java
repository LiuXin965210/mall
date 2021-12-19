package com.lx.mall;

import com.lx.mall.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MallApplicationTests {
    @Resource
    private RedisService redisService;

    @Test
    void contextLoads() {
    }

    @Test
    void redisSet() {
        redisService.set("liuxin", "1");
    }

    @Test
    void redisGet() {
        System.out.println(redisService.get("liuxin"));
    }

    @Test
    void redisExpire() {
        redisService.expire("liuxin", 1000);
    }

    @Test
    void redisRemove() {
        redisService.remove("liuxin");
    }
}
