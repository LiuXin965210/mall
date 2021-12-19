package com.lx.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置信息类
 *
 * @author LiuXin
 * @date 2021/12/12 22:48
 **/
@Configuration
@EnableSwagger2
//@EnableKnife4j
public class Swagger2Config {

//    http://localhost:8080/swagger-ui/index.html

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lx.mall.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Swagger 总体配置
     * @author LiuXin
     * @date 2021/12/18 21:52
     * @return springfox.documentation.service.ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger UI 演示")
                .description("mall-tiny")
                .contact(new Contact("liuxin", "", "1007476242@qq.com"))
                .version("1.0")
                .build();
    }
}
