package com.gpa.clinica.crm.infrastructure.config.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    private static final String SCHEME_NAME = "bearerAuth";
    private static final String BEARER_FORMAT = "JWT";
    private static final String SCHEME = "bearer";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(SCHEME_NAME)).components(new Components()
                        .addSecuritySchemes(SCHEME_NAME, new SecurityScheme()
                                .name(SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .bearerFormat(BEARER_FORMAT)
                                .in(SecurityScheme.In.HEADER)
                                .scheme(SCHEME)
                        )
                )
                .info(new Info().title("clinica-crm-api")
                        .description("API para gerenciar atendimentos de clínicas de estética e dermatologia " +
                                "com integração de IA")
                        .version("v1.0.0"));
    }
}
