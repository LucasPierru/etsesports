package com.etsesports.etsesports.game;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GameConfig {

    @Bean("gameDataLoader")
    CommandLineRunner commandLineRunner (GameRepository gameRepository) {
        return args -> {
            Game valorant = new Game("Valorant");
            Game rocketLeague = new Game("Rocket League");
            gameRepository.saveAll(List.of(valorant, rocketLeague));
        };
    }
}
