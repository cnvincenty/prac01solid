package bo.edu.uagrm.soe.prac01solid.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Practica 01 SOLID API")
                        .version("1.0")
                        .description("API para gestión de productos aplicando principios SOLID"));
    }
}