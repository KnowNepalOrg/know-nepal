package com.knownepal.education.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Know Nepal - Education API")
                        .version("1.0.0")
                        .description("Production-grade REST API for Nepal's education data — Schools, Colleges, Universities, and Programs. Includes paginated list endpoints, slug-based lookups, and full CRUD operations.")
                        .contact(new Contact()
                                .name("KnowNepal")
                                .email("info@knownepal.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8084").description("Development")));
    }
}
