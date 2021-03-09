package com.example.demo.config;


import com.example.demo.logger.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class AppConfig {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}