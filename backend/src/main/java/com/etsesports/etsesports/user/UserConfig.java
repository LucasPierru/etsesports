package com.etsesports.etsesports.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            new User(
                    1L,
                    "Luysru",
                    "lucaspierru7@gmail.com",
                    "kjehbwdkfjwhgkfjsh",
                    "bio",
                    true,
                    LocalDate.of(2025, 10,14),
                    LocalDate.of(2025, 10,14)
            );
        };
    }
}
