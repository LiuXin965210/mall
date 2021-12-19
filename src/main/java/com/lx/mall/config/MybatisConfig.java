package com.lx.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置信息类
 *
 * @author LiuXin
 * @date 2021/12/12 22:48
 **/
@Configuration
@MapperScan("com.lx.mall.mbg.mapper")
public class MybatisConfig {
}
