package com.etsesports.etsesports.player;

import com.etsesports.etsesports.team.Team;
import com.etsesports.etsesports.team.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PlayerConfig {
    @Bean("playerDataLoader")
    @DependsOn("teamDataLoader")
    @Order(3)
    CommandLineRunner commandLineRunner (TeamRepository teamRepository, PlayerRepository playerRepository) {
        return args -> {
            long valId = 1L;
            Team valorant = teamRepository.getReferenceById(valId);

            Player v1 = new Player(
                    "Luysru",
                    "Lucas",
                    "Pierru",
                    LocalDate.of(1997,6, 14),
                    "Software engineering",
                    valorant,
                    "Initiator",
                    true);
            playerRepository.saveAll(List.of(v1));
        };
    }
}
