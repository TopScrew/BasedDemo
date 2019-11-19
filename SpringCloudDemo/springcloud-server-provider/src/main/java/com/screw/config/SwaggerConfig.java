package com.screw.config;

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
@EnableSwagger2 //开启Swagger功能
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 扫描API所在的包名
                .apis(RequestHandlerSelectors.basePackage("com.screw.api")).paths(PathSelectors.any()).build();
    }
    //创建API文档信息
    private ApiInfo apiInfo() {
        //title文档标题
        //description 文档描述信息
        //termsOfServiceUrl 官网
        return new ApiInfoBuilder().title("screw Swagger测试").description("测试服务提供者 hello")
                .termsOfServiceUrl("http://www.screw.com")
                // .contact(contact)
                .version("1.0").build();
    }


}
