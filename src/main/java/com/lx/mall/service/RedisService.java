package com.lx.mall.service;

/**
 * Redis接口类
 *
 * @author LiuXin
 * @date 2021/12/19 17:50
 **/
public interface RedisService {
    /**
     * 存储数据
     * @author LiuXin
     * @date 2021/12/19 17:51
     * @param key
     * @param value
     * @return void
     */
    void set(String key, String value);

    /**
     * 获取数据
     * @author LiuXin
     * @date 2021/12/19 17:52
     * @param key
     * @return java.lang.String
     */
    String get(String key);

    /**
     * 设置过期时间
     * @author LiuXin
     * @date 2021/12/19 17:52
     * @param key
     * @param expire
     * @return boolean
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * @author LiuXin
     * @date 2021/12/19 17:52
     * @param key
     * @return void
     */
    void remove(String key);

    /**
     * 自增操作
     * @author LiuXin
     * @date 2021/12/19 17:52
     * @param key 
     * @param delta 自增步长
     * @return java.lang.Long
     */
    Long increment(String key, long delta);
}
