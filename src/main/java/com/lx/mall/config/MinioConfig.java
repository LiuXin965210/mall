package com.lx.mall.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * MinIO配置类
 *
 * @author LiuXin
 * @date 2021/12/19 23:35
 **/
public class MinioConfig {
    @Value("${minio.endpoint}")
    private String endPoint;
    @Value("${minio.port}")
    private int port;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;
    @Value("${minio.secure}")
    private boolean secure;

    @Bean
    public MinioClient getMinioClient() throws Exception {
        return new MinioClient(endPoint, port, accessKey, secretKey, secure);
    }
}
