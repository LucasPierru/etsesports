package com.etsesports.match;

import com.etsesports.game.Game;
import com.etsesports.game.GameRepository;
import com.etsesports.opponent.Opponent;
import com.etsesports.opponent.OpponentRepository;
import com.etsesports.team.Team;
import com.etsesports.team.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class MatchConfig {
    @Bean("matchDataLoader")
    @Order(8)
    CommandLineRunner commandLineRunner (MatchRepository matchRepository, TeamRepository teamRepository, OpponentRepository opponentRepository, GameRepository gameRepository) {
        return args -> {
            // prefer to use name to lookup game

            Team v1 = teamRepository.findByNameAndGameName("Valorant Team 1", "Valorant")
                    .orElseThrow(() -> new IllegalStateException("Valorant Team 1 is missing"));
            Opponent udemTeam = opponentRepository.findByNameAndSchoolName("Valorant Opponent 1", "Université de Montréal")
                    .orElseThrow(() -> new IllegalStateException("Valorant Team 1 from UdeM is missing"));
            Game valorant = gameRepository.findByName("Valorant")
                    .orElseThrow(() -> new IllegalStateException("Valorant is missing"));

            // idempotent: create only if not exists (name + game)
            Match match1 = new Match(v1, udemTeam, valorant, LocalDateTime.of(2025, 11,15,20,0), 0, 0);
            matchRepository.saveAll(List.of(match1));
        };
    }
}
