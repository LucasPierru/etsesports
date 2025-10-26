package com.etsesports.etsesports.team;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeamConfig {

    @Bean("teamDataLoader")
    CommandLineRunner commandLineRunner (TeamRepository teamRepository) {
        return args -> {
            Team v1 = new Team("Valorant");
            Team r1 = new Team("Rocket League");
            teamRepository.saveAll(List.of(v1, r1));
        };
    }
}
