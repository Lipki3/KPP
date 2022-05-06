package com.example.lab1;

import com.example.lab1.Cache.cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean("cache")
    @Scope(value = "singleton")
    cache Cache() {
        return new cache();
    }

}