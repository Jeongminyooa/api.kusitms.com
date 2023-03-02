package com.kusitms.website.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("KUSTIMS 공식 홈페이지 API Document")
                .version("v0.0.1")
                .description("KUSITMS 공식 홈페이지 프로젝트의 API 명세서");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
