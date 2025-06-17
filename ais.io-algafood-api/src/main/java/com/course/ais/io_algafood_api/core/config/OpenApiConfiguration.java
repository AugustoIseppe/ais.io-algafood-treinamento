package com.course.ais.io_algafood_api.core.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "AlgaFood API",
                version = "v1",
                contact = @Contact(
                        name = "Augusto Iseppe",
                        email = "augusto.iseppe@gmail.com",
                        url = "teste@teste.com"
                ),
                description = "API for managing a food delivery system"
        )
)
public class OpenApiConfiguration {

}
