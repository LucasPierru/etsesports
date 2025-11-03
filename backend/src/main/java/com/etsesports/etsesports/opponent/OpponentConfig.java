package com.etsesports.etsesports.opponent;

import com.etsesports.etsesports.school.School;
import com.etsesports.etsesports.school.SchoolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

@Configuration
public class OpponentConfig {
    @Bean("opponentDataLoader")
    @DependsOn("schoolDataLoader")
    @Order(7)
    CommandLineRunner commandLineRunner (OpponentRepository opponentRepository, SchoolRepository schoolRepository) {
        return args -> {
            // prefer to use name to lookup game
            School udem = schoolRepository.findByName("Université de Montréal")
                    .orElseThrow(() -> new IllegalStateException("UdeM missing"));

            // idempotent: create only if not exists (name + game)
            createOpponentIfMissing(opponentRepository, "Valorant Opponent 1", udem);
            createOpponentIfMissing(opponentRepository, "Valorant Opponent 2", udem);
        };
    }

    private void createOpponentIfMissing(OpponentRepository opponentRepository, String opponentName, School school) {
        if (opponentRepository.findByNameAndSchool(opponentName, school).isEmpty()) {
            opponentRepository.save(new Opponent(opponentName, school));
        }
    }
}
