package com.generation.test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Students API")
                        .description("generation brazil challenge")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Amanda Lobo")
                                .email("amandalobo.ag@gmail.com")
                                .url("https://www.linkedin.com/in/amandag-lobo/")
                                .url("https://github.com/amanda-lobo")));
    }
}
