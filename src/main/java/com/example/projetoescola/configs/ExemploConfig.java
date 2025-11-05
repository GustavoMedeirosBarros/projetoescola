package com.example.projetoescola.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExemploConfig {

    @Bean
    public String versaoApi() {
        return "1.0.0";
    }

    @Bean(name = "nome")
    public String nomeApi() {
        return "Api Exemplo";
    }
}
