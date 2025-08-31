package com.example.livraria.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Livraria na Nuvem - API")
                        .description("CRUD de livros com Spring Boot + PostgreSQL")
                        .version("v1.0"));
    }
}
