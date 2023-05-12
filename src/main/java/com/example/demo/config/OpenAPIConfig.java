package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI(){
        return new OpenAPI();
    }
}
