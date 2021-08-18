package com.chi.seckill.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Tag;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String TAG_1 = "tag1";

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
//                .tags(new Tag(TAG_1, "讲师管理"))
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger在线API文档")
                .version("1.0")
                .contact(new Contact("迟宇航", "https://www.yuque.com/books/share/e5f56e7c-8cec-4150-b23d-e8d786697acc", "863543229@qq.com"))
                .build();
    }
}
