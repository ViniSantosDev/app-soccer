package br.com.vinisantosdev.app_soccer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Futebol")
                        .version("1.0.0")
                        .description("Documentação da API para gerenciar times, campeonatos e jogos."));
    }
}
