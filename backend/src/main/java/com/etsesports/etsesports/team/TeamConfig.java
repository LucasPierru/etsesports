package com.etsesports.etsesports.team;

import com.etsesports.etsesports.game.Game;
import com.etsesports.etsesports.game.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

@Configuration
public class TeamConfig {

    @Bean("teamDataLoader")
    @DependsOn("gameDataLoader")
    @Order(2)
    CommandLineRunner commandLineRunner (TeamRepository teamRepository, GameRepository gameRepository) {
        return args -> {
            // prefer to use name to lookup game
            Game valorant = gameRepository.findByName("Valorant")
                    .orElseThrow(() -> new IllegalStateException("Valorant missing"));

            // idempotent: create only if not exists (name + game)
            createTeamIfMissing(teamRepository, "Valorant Team 1", valorant);
            createTeamIfMissing(teamRepository, "Valorant Team 2", valorant);
        };
    }

    private void createTeamIfMissing(TeamRepository teamRepository, String teamName, Game game) {
        if (teamRepository.findByNameAndGame(teamName, game).isEmpty()) {
            teamRepository.save(new Team(teamName, game));
        }
    }
}
