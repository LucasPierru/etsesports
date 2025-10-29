package com.etsesports.etsesports.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean("userDataLoader")
    @Order(4)
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User lucas = new User("Luysru", "lucaspierru7@gmail.com", "kjhfgkswdjhflksadj", Role.ADMIN, true);
            User alex = new User("Alex", "alex@gmail.com", "lkdsfjgvhjekldsjhgvks", Role.COACH, true);

            repository.saveAll(
                    List.of(lucas, alex)
            );
        };
    }
}
