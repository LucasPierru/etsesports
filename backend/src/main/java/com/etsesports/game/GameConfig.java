package com.etsesports.game;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class GameConfig {

    @Bean("gameDataLoader")
    @Order(1)
    CommandLineRunner commandLineRunner (GameRepository gameRepository) {
        return args -> {
            createIfMissing(gameRepository, "Valorant");
            createIfMissing(gameRepository, "Rocket League");
        };
    }

    private void createIfMissing(GameRepository gameRepository, String name) {
        gameRepository.findByName(name).orElseGet(() -> gameRepository.save(new Game(name)));
    }
}
