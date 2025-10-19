package com.etsesports.etsesports.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User lucas = new User(
                    "Luysru",
                    "lucaspierru7@gmail.com",
                    "kjehbwdkfjwhgkfjsh",
                    "bio",
                    true,
                    LocalDate.of(2025, 10,14),
                    LocalDate.of(2025, 10,14),
                    LocalDate.of(1997, 6, 14)
            );

            User alex = new User(
                    "Alex",
                    "alex@gmail.com",
                    "kjehbwdkfjwhgkfjsh",
                    "bio",
                    true,
                    LocalDate.of(2025, 10,15),
                    LocalDate.of(2025, 10,15),
                    LocalDate.of(1996, 3, 12)
            );

            repository.saveAll(
                    List.of(lucas, alex)
            );
        };
    }
}
