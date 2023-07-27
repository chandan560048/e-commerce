package com.ecommerce.alpha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI awesomeAPI() {
        return new OpenAPI()
                .info(new Info().title("Awesome API Title")
                        .description("Awesome API Description")
                        .version("1.0")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Ranga Karanam, in28minutes@gmail.com")
                        .url("http://www.in28minutes.com"));
    }

}