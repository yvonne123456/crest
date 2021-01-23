package com.hcc.crest.config;

import com.hcc.crest.CRestApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String KA_LEI_Xing = "卡类型";

    @Bean
    public Docket createRestApi() {
        String basePck = CRestApplication.class.getPackage().getName();
        System.out.println(basePck+"=启动类所在的包为路径扫描=====定义生成接口文档的包路径=====");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePck))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HCC 卡类型 接口文档")
                .description("描述内容")
                .version("231")
                .build();
    }
}