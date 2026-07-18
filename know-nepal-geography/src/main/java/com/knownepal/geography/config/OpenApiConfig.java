package com.knownepal.geography.config;

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
                        .title("Know Nepal - Geography API")
                        .version("1.0.0")
                        .description("Production-grade REST API for Nepal's geographic data — Provinces, Districts, Municipalities, Wards, and Emergency Contacts. Includes paginated list endpoints, slug-based lookups, global search, and full CRUD operations.")
                        .contact(new Contact()
                                .name("KnowNepal")
                                .email("info@knownepal.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Development")));
    }
}
