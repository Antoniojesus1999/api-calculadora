package com.iteriam.sanitas.calculadora.config;

import com.iteriam.sanitas.calculadora.log.Logger;
import com.iteriam.sanitas.calculadora.log.impl.LoggerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Logger logger() {
        return new LoggerImpl();
    }
}
