package com.etsesports.etsesports.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class SchoolConfig {
    @Bean("schoolDataLoader")
    @Order(6)
    CommandLineRunner commandLineRunner (SchoolRepository schoolRepository) {
        return args -> {
            School ets = new School("École de technologie supérieure");
            School udem = new School("Université de Montréal");

            schoolRepository.saveAll(List.of(ets, udem));
        };
    }
}
