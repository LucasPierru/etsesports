package com.etsesports.etsesports.team;

import com.etsesports.etsesports.game.Game;
import com.etsesports.etsesports.game.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeamConfig {

    @Bean("teamDataLoader")
    CommandLineRunner commandLineRunner (TeamRepository teamRepository, GameRepository gameRepository) {
        return args -> {
            long valId = 1;
            Game valorant = gameRepository.findById(valId).orElseThrow(() -> new IllegalStateException("Game with id " + valId + " does not exist"));;

            Team v1 = new Team("Valorant", valorant);
            Team r1 = new Team("Rocket League", valorant);
            teamRepository.saveAll(List.of(v1, r1));
        };
    }
}
